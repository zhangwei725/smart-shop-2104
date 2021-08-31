package com.smart.order.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.order.entity.Stock;
import org.apache.ibatis.annotations.Param;

public interface StockMapper extends BaseMapper<Stock> {
    /**
     * 通过商品ID查询库存
     *
     * @return
     */
    default Stock selectQuantityByProductId(Long productId, int quantity) {
        QueryWrapper<Stock> qw = new QueryWrapper<>();
        qw.lambda().select(Stock::getStockId, Stock::getProductId, Stock::getTotal, Stock::getVersion).eq(Stock::getProductId, productId).ge(Stock::getTotal, quantity);
        return this.selectOne(qw);
    }

    int updateStockByProductId(@Param("stock") Stock stock);

}