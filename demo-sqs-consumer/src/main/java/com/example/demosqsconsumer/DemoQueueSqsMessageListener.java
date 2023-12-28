package com.example.demosqsconsumer;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class DemoQueueSqsMessageListener {

    @SqsListener("demoQueue")
    public void listenDemoMessage(String message) {
        log.info("Receiving message {}", message);
    }
}
