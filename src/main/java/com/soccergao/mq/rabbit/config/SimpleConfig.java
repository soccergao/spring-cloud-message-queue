package com.soccergao.mq.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleConfig {
    @Bean
    public Queue simpleQueue() {
        return new Queue(Constant.SIMPLE_QUEUE);
    }

}
