package com.soccergao.mq.rabbit.listener;

import com.soccergao.mq.rabbit.config.Constant;
import com.soccergao.mq.rabbit.object.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @Autowired
    SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory;

    @RabbitListener(queues = Constant.SIMPLE_QUEUE)
    public void simpleListener(String message) {
        System.out.println("收到message: " + message);
        throw new NullPointerException();
    }

    @RabbitListener(queues = Constant.DIRECT_QUEUE)
    public void directListener(User userResponse) {
        System.out.println(userResponse.getUsername());
//        System.out.println(userResponse);
        throw new NullPointerException();
    }

    @RabbitListener(queues = Constant.TOPIC_QUEUE)
    public void topicListener(String message) {
        System.out.println(message);
    }

    @RabbitListener(queues = Constant.FANOUT_QUEUE_ONE)
    public void fanoutListener_one(String message) {
        System.out.println("listener one: " + message);
    }

    @RabbitListener(queues = Constant.FANOUT_QUEUE_TWO)
    public void fanoutListener_two(String message) {
        System.out.println("listener two: " + message);
    }
}
