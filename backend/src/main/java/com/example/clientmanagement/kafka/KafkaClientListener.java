package com.example.clientmanagement.kafka;

import com.example.clientmanagement.model.Client;
import com.example.clientmanagement.service.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaClientListener {
    private final ClientService clientService;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "new-client", groupId = "client-group")
    public void listen(String message) {
        try {
            Client client = objectMapper.readValue(message, Client.class);
            clientService.saveClient(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}