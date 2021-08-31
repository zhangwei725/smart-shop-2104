package com.smart.order.service.impl;

import com.smart.order.entity.Cart;
import com.smart.order.mapper.CartMapper;
import com.smart.order.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Service
public class CartServiceImpl implements CartService {
    @Resource
    CartMapper cartMapper;


    @Override
    public List<Cart> getCarts(List<Long> ids) {
        return cartMapper.selectBatchIds(ids);
    }
}
