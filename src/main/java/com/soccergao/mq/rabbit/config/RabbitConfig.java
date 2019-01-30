package com.soccergao.mq.rabbit.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {


//    @Bean //sender配置
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory);
//        template.setMessageConverter(messageConverter);
//        return template;
//    }

//    @Bean //listener配置
//    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(ConnectionFactory connectionFactory, SimpleRabbitListenerContainerFactoryConfigurer configurer) {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        configurer.configure(factory, connectionFactory); //读取yml里的配置内容
//        factory.setMessageConverter(messageConverter());
//        return factory;
//    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

//    /**
//     * 确认消息（全局处理消息）(手动确认) 未验证
//     * @param connectionFactory
//     * @return
//     */
//    @Bean
//    public SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory){
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames("consumer_queue");              // 监听的队列
//        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);        // 手动确认
//        container.setMessageListener((ChannelAwareMessageListener) (message, channel) -> {      //消息处理
//            System.out.println("====接收到消息=====");
//            System.out.println(new String(message.getBody()));
//            if(message.getMessageProperties().getHeaders().get("error") == null){   // 判断消息头是否有error属性
//                channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//                System.out.println("消息已经确认");
//            }else {
//                //channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
//                channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
//                System.out.println("消息拒绝");
//            }
//
//        });
//        return container;
//    }
}
