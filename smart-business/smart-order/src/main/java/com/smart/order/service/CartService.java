package com.smart.order.service;

import com.smart.order.entity.Cart;

import java.util.List;

/**
 * where  cartId  in(1,2)
 */
public interface CartService {
    List<Cart> getCarts(List<Long> ids);
}
