package com.example.demo;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SqsMessageSender {

    private SqsTemplate sqsTemplate;

    public void send(String queueName, String message) {
        sqsTemplate.send(queueName, MessageBuilder.withPayload(message).build());
    }
}
