package org.example.controller_service.controller;


import org.example.controller_service.service.ConnectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ControllerController {

    private final ConnectionService connectionService;

    public ControllerController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @PostMapping
    public ResponseEntity<String> post(@RequestBody String json) {
        return connectionService.postMessage(json);
    }

    @GetMapping
    public ResponseEntity<String> getAll() {
        return connectionService.getMessages();
    }

    @GetMapping("{id}")
    public ResponseEntity<String> getById(@PathVariable("id") Long id) {
        return connectionService.getMessageById(id);
    }
}
