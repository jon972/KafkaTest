package com.example.clientmanagement.service;

import com.example.clientmanagement.model.Client;
import com.example.clientmanagement.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value("${app.system-id}")
    private String systemId;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client saveClient(Client client) {
        Client savedClient = clientRepository.save(client);
        try {
            client.setSourceSystem(systemId);
            kafkaTemplate.send("new-client", objectMapper.writeValueAsString(savedClient));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savedClient;
    }
}