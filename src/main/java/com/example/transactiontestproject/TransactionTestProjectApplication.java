package com.example.transactiontestproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TransactionTestProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransactionTestProjectApplication.class, args);
    }
}
