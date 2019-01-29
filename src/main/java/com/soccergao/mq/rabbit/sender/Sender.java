package com.soccergao.mq.rabbit.sender;

import com.soccergao.mq.rabbit.config.Constant;
import com.soccergao.mq.rabbit.object.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    AmqpTemplate amqpTemplate;

    public void simpleSender() {
        String message = "simple sender";
        amqpTemplate.convertAndSend(Constant.DIRECT_QUEUE, message); // routing_key默认与queue名字相同
    }

    public void directSender() {
        User userRequest = new User("sa", "sa");
        amqpTemplate.convertAndSend(Constant.DIRECT_QUEUE, userRequest);    // routing_key默认与queue名字相同
    }

    public void fanoutSender() {
        String message = "fanout sender";
        String routingKey = "";
        amqpTemplate.convertAndSend(Constant.FANOUT_EXCHANGE, routingKey, message);
    }
}
