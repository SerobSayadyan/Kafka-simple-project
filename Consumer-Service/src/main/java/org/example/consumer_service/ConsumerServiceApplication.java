package org.example.consumer_service;

import org.example.consumer_service.db.DatabaseInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerServiceApplication {

    public static void main(String[] args) {
        DatabaseInitializer.createDatabaseIfNotExists();
        SpringApplication.run(ConsumerServiceApplication.class, args);
    }

}
