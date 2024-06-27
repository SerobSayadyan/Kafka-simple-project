package org.example.producer_service.producer.service;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private static final String TOPIC = "my-topic";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String sendMessage(String message) {
        return kafkaTemplate.send(TOPIC, message).toString();
    }

}
