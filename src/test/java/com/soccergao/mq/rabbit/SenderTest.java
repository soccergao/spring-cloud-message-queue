package com.soccergao.mq.rabbit;

import com.soccergao.mq.rabbit.sender.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SenderTest {
    @Autowired
    Sender sender;

    @Test
    public void simpleSender() {
        sender.simpleSender();
    }

    @Test
    public void directSender() {
        sender.directSender();
    }

    @Test
    public void topicSender() {
        sender.topicSender();
    }

    @Test
    public void fanoutSender() {
        sender.fanoutSender();
    }
}