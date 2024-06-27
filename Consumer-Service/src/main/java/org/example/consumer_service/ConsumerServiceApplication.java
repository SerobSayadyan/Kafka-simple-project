package org.example.consumer_service;

import org.example.consumer_service.db.DatabaseInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerServiceApplication {

    public static void main(String[] args) {
        try {
            //This time is needed so that postgresSQL will be created in docker
            new Thread(() -> {
                DatabaseInitializer.createDatabaseIfNotExists();
                SpringApplication.run(ConsumerServiceApplication.class, args);
            }).wait(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
