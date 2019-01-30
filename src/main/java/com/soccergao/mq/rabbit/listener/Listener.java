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
        throw new NullPointerException();
    }

//    /**
//     *
//     * @param userResponse
//     * @param channel
//     * @param map 消息头的内容, 获取DELIVERY_TAG也可以直接使用@Header(AmqpHeaders.DELIVERY_TAG) long tag
//     * @throws IOException
//     */
//    @RabbitListener(queues = Constant.DIRECT_QUEUE)
//    public void directListener(User userResponse, Channel channel, @Headers Map<String, Object> map/*, @Header(AmqpHeaders.DELIVERY_TAG) long tag*/) throws IOException {
//        System.out.println(userResponse.getUsername());
//        /**
//         * ack
//         *
//         * multiple：为了减少网络流量，手动确认可以被批处理，当该参数为 true 时，则可以一次性确认 delivery_tag 小于等于传入值的所有消息
//         */
//        channel.basicAck((Long) map.get(AmqpHeaders.DELIVERY_TAG), false);
//        /**
//         * nack
//         *
//         * multiple：为了减少网络流量，手动确认可以被批处理，当该参数为 true 时，则可以一次性确认 delivery_tag 小于等于传入值的所有消息
//         * requeue：是否丢弃, true为不丢弃重回队列, false为丢弃或进入死信队列
//         */
//        channel.basicNack((Long) map.get(AmqpHeaders.DELIVERY_TAG), false, true);
//        /**
//         * reject
//         *
//         * requeue：是否丢弃, true为不丢弃重回队列, false为丢弃或进入死信队列
//         */
//        channel.basicReject((Long) map.get(AmqpHeaders.DELIVERY_TAG), true);
//    }

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
