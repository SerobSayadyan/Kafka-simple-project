package org.example.producer_service.producer.controller;

import org.example.producer_service.producer.service.ProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer-api")
public class ProducerController {

    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/send")
    private String sendMessage(@RequestBody String message) {
        return "Message have been sent successfully: " + producerService.sendMessage(message);
    }

}

