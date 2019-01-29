package com.soccergao.mq.rabbit.config;

public class Constant {
    public static final String SIMPLE_QUEUE = "soccer.gao.simple";

    public static final String X_DEAD_LETTER_EXCHANGE = "x-dead-letter-exchange";       //队列属性固定值
    public static final String X_DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key"; //队列属性固定值

    /** direct exchange */
//    public final String DIRECT_EXCHANGE = "direct.exchange";
//    public final String DIRECT_ROUTING_KEY = "direct.routing.key";
    public static final String DIRECT_QUEUE = "direct.queue";
    public static final String DIRECT_EXCHANGE_DXL = "direct.exchange.dxl";
    public static final String DIRECT_ROUTING_KEY_DXL = "direct.routing.key.dxl";
    public static final String DIRECT_QUEUE_DXL = "direct.queue.dxl";

    /** fanout exchange */
    public static final String FANOUT_EXCHANGE = "fanout.exchange";
    public static final String FANOUT_QUEUE_ONE = "fanout.queue.one";
    public static final String FANOUT_QUEUE_TWO = "fanout.queue.two";
}
