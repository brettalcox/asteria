package com.bta.astro.asteria.listener;

import com.bta.astro.asteria.entity.AstronomicalObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MessageListener {

    @RabbitListener(queues = "spring-boot")
    public void receiveMessage(AstronomicalObject test) throws IOException {
        System.out.println(test.toString());
    }
}
