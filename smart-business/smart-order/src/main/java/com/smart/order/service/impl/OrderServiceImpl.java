package com.smart.order.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.common.exception.ServiceException;
import com.smart.common.utils.ConvertBeanUtils;
import com.smart.common.vo.ResponseCode;
import com.smart.order.dto.OrderDto;
import com.smart.order.entity.Cart;
import com.smart.order.entity.Order;
import com.smart.order.entity.OrderItem;
import com.smart.order.entity.Stock;
import com.smart.order.mapper.CartMapper;
import com.smart.order.mapper.OrderItemMapper;
import com.smart.order.mapper.OrderMapper;
import com.smart.order.mapper.StockMapper;
import com.smart.order.reqeust.OrderReqeustParams;
import com.smart.order.reqeust.ProductRequestParams;
import com.smart.order.service.CartService;
import com.smart.order.service.OrderService;
import com.smart.order.vo.OrderVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 产品
 * po  持久化对象  数据层的入口参数 返回参数
 * vo  视图对象  作为控制层返回对象  业务层返回vo对象  pc端  移动端
 * qo  请求参数  控制层入口参数    业务层入口参数
 * com.smart.member.dto 服务跟服务之间数据传输对象   业务层的返回对象
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    CartService cartService;
    @Resource
    OrderMapper orderMapper;
    @Resource
    OrderItemMapper orderItemMapper;
    @Resource
    StockMapper stockMapper;
    @Resource
    CartMapper cartMapper;


    /**
     * 防止重复提交
     * <p>
     * 订单类型
     * 购物车订单 秒杀订单  团购订单  直接购买, 预售订单
     * 生成订单
     * 1. 订单号
     * 1.1 > 确保唯一  可读性  ,安全性  规则  数据增长  性能问题
     * 8   4     2  10 pc 11 安卓  12 ios  20 小程序  31 其他  4
     * 订单日期  + 随机数 + 订单来源 +  用户ID +
     * 2 > 计算总金额
     * 优惠券   现金券  满减   折扣
     * 3. 减少库存 下单减库存,支付减库存
     * 4. 保存订单信息
     * 5. 删除购物车商品信息
     *
     * @param orderRequestParams
     * @return 悲观锁  性能下降  保证数据安全
     * 乐观锁 保证性能  保证数据安全
     * 小河   查询  quantity 10   version  1
     * int  count = update   quantity=8    version = version+1    where  version=1 and  product_id = 1
     * 菜火火  查询  quantity 10   version  1
     * update   quantity=7    version = version+1    where  version=1 and  product_id = 1
     * 数据库    quantity 7        version  2
     */
    @Override
    @Transactional
    public OrderVo createOrder(OrderReqeustParams orderRequestParams) {
        String orderNo = createNo(orderRequestParams.getMemberId(), orderRequestParams.getPlatformType());
        // 1.从购物中将商品信息查询出来
        List<Long> ids = orderRequestParams
                .getProductParamsList()
                .stream().map(ProductRequestParams::getCartId)
                .collect(Collectors.toList());
        // 从购物车获取选中的商品信息
        List<Cart> carts = cartService.getCarts(ids);
        // 计算总金额
        BigDecimal bigDecimal = totalPrice(carts, orderNo);
        // 2.保存 oms_order oms_order_item
        Order order = new Order();
        order.setOrderNo(orderNo);
        order.setTotal(bigDecimal);
        order.setMemberId(orderRequestParams.getMemberId());
        order.setUsername(orderRequestParams.getReceiverName());
        order.setPhone(orderRequestParams.getReceiverPhone());
        order.setDetail(orderRequestParams.getReceiverAddress());
        orderMapper.insert(order);
//        List<Long> cartIds = new ArrayList<>();
//        carts.forEach(cart -> {
//            cartIds.add(cart.getCartId());
//        });
        List<Long> cartIds = carts.stream().map(Cart::getCartId).collect(Collectors.toList());
        //删除购物车信息
        delCarts(cartIds);



        return OrderVo.builder()
                .total(bigDecimal)
                .orderNo(orderNo)
                .subject(carts.get(0).getTitle())
                .build();
    }


    /**
     * 创建订单号
     *
     * @return
     */
    private String createNo(Long memberId, int platformType) {
        return String.format("%s%s%s%s"
                , DateUtil.format(new Date(), "yyyyMMdd")
                , RandomUtil.randomNumbers(4)
                , platformType
                , memberId
        );
    }

    /**
     * 计算总金额
     *
     * @return
     */
    public BigDecimal totalPrice(List<Cart> carts, String orderNo) {
        BigDecimal totalPrice = new BigDecimal("0.00");
        for (Cart cart : carts) {
            BigDecimal disPrice = cart.getDiscountPrice();
            BigDecimal quantity = new BigDecimal(cart.getQuantity().toString());
            BigDecimal multiply = disPrice.multiply(quantity);
            totalPrice = totalPrice.add(multiply);
            Stock stock = stockMapper.selectQuantityByProductId(cart.getProductId(), cart.getQuantity());
            if (stock != null) {
                stock.setTotal(stock.getTotal() - cart.getQuantity());
                stockMapper.updateStockByProductId(stock);
                saveOrderItem(cart, orderNo);
            } else {
                throw new ServiceException(ResponseCode.ORDER_STOCK_NO);
            }

        }
        return totalPrice;
    }

    /**
     * @param cart
     */
    private void saveOrderItem(Cart cart, String orderNo) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderNo(orderNo);
        BeanUtils.copyProperties(cart, orderItem);
        int insert = orderItemMapper.insert(orderItem);
        if (insert == 0) {
            throw new ServiceException(ResponseCode.ERROR);
        }
    }

    private void delCarts(List<Long> ids) {
        int count = cartMapper.deleteBatchIds(ids);
        if (count == 0) {
            throw new ServiceException(ResponseCode.ERROR);
        }
    }

    //po对象转化 com.smart.member.dto
    @Override
    public Page<OrderDto> getOrdersByMemberId(Long memberId, Integer page, Integer size) {
        Page<Order> orderPage = orderMapper.selectOrdersByMemberId(memberId, page, size);
        Page<OrderDto> orderDtoPage = new Page<>();
        orderDtoPage.setRecords(ConvertBeanUtils.convertListTo(orderPage.getRecords(), OrderDto::new));
        orderDtoPage.setPages(orderPage.getPages());
        orderDtoPage.setTotal(orderPage.getTotal());
        return orderDtoPage;
    }

}
