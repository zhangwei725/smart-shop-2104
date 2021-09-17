package com.smart.order.msg;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderMsgServiceImpl implements OrderMsgService {
    public static final String ORDER_CANCEL_TOPIC = "order-cancel-topic";

    @Resource
    RocketMQTemplate template;

    @Override
    public void cancelOrder(String orderNo) {
        Message<String> msg = MessageBuilder.withPayload(orderNo).build();
        template.syncSend(ORDER_CANCEL_TOPIC, msg, 3000, 9);
    }
}
