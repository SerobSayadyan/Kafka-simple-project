package org.example.consumer_service.consumer.controller;


import org.example.consumer_service.db.entities.MessageEntity;
import org.example.consumer_service.db.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer-api")
public class ConsumerController {

    private final MessageService messageService;

    public ConsumerController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<MessageEntity> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("{id}")
    public MessageEntity getMessageById(@PathVariable Long id) {
        return messageService.getMessageById(id);
    }
}
