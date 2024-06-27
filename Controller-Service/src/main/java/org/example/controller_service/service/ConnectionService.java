package org.example.controller_service.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ConnectionService {

    @SuppressWarnings("all")
    private final String producerURL = "http://producer-service:8081";
    private final String consumerURL = "http://consumer-service:8082";
    private final RestTemplate restTemplate = new RestTemplate();


    public ResponseEntity<String> postMessage(String postRequestBody) {
        HttpHeaders postHeaders = new HttpHeaders();
        postHeaders.setContentType(MediaType.APPLICATION_JSON);

        // Build the HTTP entity with headers and body for POST request
        HttpEntity<String> postRequestEntity = new HttpEntity<>(postRequestBody, postHeaders);

        // Send POST request and retrieve response
        return restTemplate.exchange(
                producerURL + "/producer-api/send",
                HttpMethod.POST,
                postRequestEntity,
                String.class
        );
    }

    public ResponseEntity<String> getMessages() {
        HttpHeaders getHeaders = new HttpHeaders();
        getHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        // Build HTTP entity for GET request
        HttpEntity<Void> getRequestEntity = new HttpEntity<>(getHeaders);

        return restTemplate.exchange(
                consumerURL + "/consumer-api",
                HttpMethod.GET,
                getRequestEntity,
                String.class
        );
    }

    public ResponseEntity<String> getMessageById(Long id) {
        HttpHeaders getHeaders = new HttpHeaders();
        getHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        // Build HTTP entity for GET request
        HttpEntity<Void> getRequestEntity = new HttpEntity<>(getHeaders);

        return restTemplate.exchange(
                consumerURL + "/consumer-api/" + id,
                HttpMethod.GET,
                getRequestEntity,
                String.class
        );
    }
}
