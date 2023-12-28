package com.example.demo.domain;

import com.example.demo.domain.entities.OutboxTableEntity;
import com.example.demo.domain.repositories.OutboxTableRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;

@AllArgsConstructor
@Component
public class OutboxTableService {

    private OutboxTableRepository repository;
    public void create(String queueName, String message) {
        OutboxTableEntity outboxTable = OutboxTableEntity.builder()
                .createdTimestamp(System.currentTimeMillis())
                .message(message)
                .queueName(queueName)
                .build();
        repository.save(outboxTable);
    }

}
