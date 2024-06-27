package org.example.consumer_service.consumer.service;

import org.example.consumer_service.db.service.MessageService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private final MessageService messageService;

    public ConsumerService(MessageService messageService) {
        this.messageService = messageService;
    }

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public String listen(String message) {
        messageService.saveMessage(message);
        return message;
    }

}
