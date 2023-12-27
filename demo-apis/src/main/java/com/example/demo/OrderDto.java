package com.example.demo;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Builder
@Data
public class OrderDto {

    private String status;
    private BigDecimal totalAmount;

}
