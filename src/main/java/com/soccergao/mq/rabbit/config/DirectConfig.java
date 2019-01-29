package com.soccergao.mq.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * direct exchange
 * 初始化一旦生成 无法更改
 */
@Configuration
public class DirectConfig {
    /** 注释部分使用默认的exchange */
//    @Bean
//    public Exchange exchange() {
//        return ExchangeBuilder
//                .directExchange(Constant.FULL_DIRECT_EXCHANGE)
//                .durable(true)
//                .build();
//    }
//
//    @Bean
//    public Binding binding() {
//        return BindingBuilder
//                .bind(queue())
//                .to(exchange())
//                .with(Constant.FULL_DIRECT_ROUTING_KEY)
//                .noargs();
//    }

    @Bean
    public Queue directQueue() {
        return QueueBuilder
                .durable(Constant.DIRECT_QUEUE)
                .withArgument(Constant.X_DEAD_LETTER_EXCHANGE, Constant.DIRECT_EXCHANGE_DXL)
                .withArgument(Constant.X_DEAD_LETTER_ROUTING_KEY, Constant.DIRECT_ROUTING_KEY_DXL)
                .build();
    }

    @Bean
    public Exchange directDxlExchange() {
        return ExchangeBuilder
                .directExchange(Constant.DIRECT_EXCHANGE_DXL)
//                .durable(true) //默认为true
                .build();
    }

    @Bean
    public Queue directDxlQueue() {
        return QueueBuilder
                .durable(Constant.DIRECT_QUEUE_DXL)
                .build();
    }

    @Bean
    public Binding directDxlBinding() {
        return BindingBuilder
                .bind(directDxlQueue())
                .to(directDxlExchange())
                .with(Constant.DIRECT_ROUTING_KEY_DXL)
                .noargs();
    }
}
