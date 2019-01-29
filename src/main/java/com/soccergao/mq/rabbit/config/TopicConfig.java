package com.soccergao.mq.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(Constant.TOPIC_EXCHANGE);
    }

    @Bean
    public Queue topicQueue() {
        return new Queue(Constant.TOPIC_QUEUE);
    }

    @Bean
    public Binding topicBinding() {
        return BindingBuilder
                .bind(topicQueue())
                .to(topicExchange())
                .with(Constant.TOPIC_ROUTING_KEY);
    }
}
