package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories
@EnableScheduling
@SpringBootApplication
public class DemoProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoProducerApplication.class, args);
    }

}
