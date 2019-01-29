package com.soccergao.mq.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange(Constant.FANOUT_EXCHANGE);
    }

    @Bean
    public Queue queueOne() {
        return QueueBuilder
                .durable(Constant.FANOUT_QUEUE_ONE)
                .build();
    }

    @Bean
    public Queue queueTwo() {
        return QueueBuilder
                .durable(Constant.FANOUT_QUEUE_TWO)
                .build();
    }

    @Bean
    public Binding bindingOne() {
        return BindingBuilder
                .bind(queueOne())
                .to(exchange());
    }

    @Bean
    public Binding bindingTwo() {
        return BindingBuilder
                .bind(queueTwo())
                .to(exchange());
    }
}
