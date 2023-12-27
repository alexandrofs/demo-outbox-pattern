package com.example.demo;

import com.example.demo.domain.entities.OutboxTableEntity;
import com.example.demo.domain.repositories.OutboxTableRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

@Slf4j
@Component
public class OutboxTableProcessor {

    @Autowired
    private OutboxTableRepository repository;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private SqsMessageSender messageSender;

    @Scheduled(fixedRate = 500)
    public void process() {
        transactionTemplate.executeWithoutResult( f -> {
            Page<OutboxTableEntity> page = repository.findAll(PageRequest.ofSize(1));
            page.forEach(item -> {
                sendMessage(item.getQueueName(), item.getMessage());
                repository.deleteById(item.getId());
            });
        });
    }

    private void sendMessage(String queueName, String message) {
        log.info("Sending message to: {}", queueName);
        messageSender.send(queueName, message);
    }
}
