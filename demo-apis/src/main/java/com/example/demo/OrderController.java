package com.example.demo;

import com.example.demo.domain.OutboxTableService;
import com.example.demo.domain.entities.OrderEntity;
import com.example.demo.domain.entities.OutboxTableEntity;
import com.example.demo.domain.repositories.OrderRepository;
import com.example.demo.domain.repositories.OutboxTableRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderController {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OutboxTableService outboxTableService;

    @PostMapping("/v1/order")
    public OrderDto createTransaction(@RequestBody OrderDto order) {

        log.info("Creating order: {}", order);

        OrderEntity orderEntity = OrderEntity.builder()
                .status("CREATED")
                .totalAmount(order.getTotalAmount())
                .build();

        OrderDto.OrderDtoBuilder dtoBuilder = OrderDto.builder();

        transactionTemplate.executeWithoutResult(f -> {
            OrderEntity orderEntitySaved = orderRepository.save(orderEntity);
            dtoBuilder
                    .status(orderEntitySaved.getStatus())
                    .totalAmount(orderEntitySaved.getTotalAmount());
            outboxTableService.create("demoQueue", "Order " + orderEntitySaved.getId() + " created");
        });

        return dtoBuilder.build();

    }
}
