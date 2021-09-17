package com.smart.order.listener;

import com.smart.order.mapper.OrderMapper;
import com.smart.order.msg.OrderMsgServiceImpl;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 订单自动取消  延迟消息
 * 发送消息     async
 * 消息服务     顺序消息
 * 事务消息
 */
@Component
@RocketMQMessageListener(consumerGroup = OrderCancelListener.ORDER_CANCEL_CONSUMER_GROUP, topic = OrderMsgServiceImpl.ORDER_CANCEL_TOPIC)
public class OrderCancelListener implements RocketMQListener<String> {
    public static final String ORDER_CANCEL_CONSUMER_GROUP = "order-cancel";
    @Resource
    OrderMapper orderMapper;

    @Override
    public void onMessage(String message) {
        int count = orderMapper.updateOrder(message);
        if (count == 0) {
            // order_cancel_error_logs
        }
    }
}
