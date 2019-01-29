package com.soccergao.mq.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(Constant.FANOUT_EXCHANGE);
    }

    @Bean
    public Queue fanoutQueueOne() {
        return QueueBuilder
                .durable(Constant.FANOUT_QUEUE_ONE)
                .build();
    }

    @Bean
    public Queue fanoutQueueTwo() {
        return QueueBuilder
                .durable(Constant.FANOUT_QUEUE_TWO)
                .build();
    }

    @Bean
    public Binding fanoutBindingOne() {
        return BindingBuilder
                .bind(fanoutQueueOne())
                .to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBindingTwo() {
        return BindingBuilder
                .bind(fanoutQueueTwo())
                .to(fanoutExchange());
    }
}
