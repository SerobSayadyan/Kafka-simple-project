package org.example.consumer_service.db.service;

import org.example.consumer_service.db.entities.MessageEntity;
import org.example.consumer_service.db.repositories.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final Logger logger = LoggerFactory.getLogger(MessageService.class);

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void saveMessage(String messageJson) {
        MessageEntity newMessage = new MessageEntity();
        newMessage.setMessage(messageJson);
        logger.info(Marker.ANY_MARKER, "Message received: " + messageJson);
        messageRepository.save(newMessage);
    }

    public MessageEntity getMessageById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }

    public List<MessageEntity> getAllMessages() {
        return messageRepository.findAll();
    }

}
