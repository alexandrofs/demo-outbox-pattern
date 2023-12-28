package com.example.demo.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
@Entity(name = "TB_OUTBOX_TABLE")
public class OutboxTableEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "QUEUE_NAME")
    private String queueName;

    @Column(name = "CREATED_TIMESTAMP")
    private Long createdTimestamp;

    public OutboxTableEntity() {

    }
}
