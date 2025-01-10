package com.example.clientmanagement.kafka;

import com.example.clientmanagement.model.Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.example.clientmanagement.model.ClientMessage;
import com.example.clientmanagement.repository.ClientRepository;
import com.example.clientmanagement.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Value;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaClientListener {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Value("${app.system-id}")
    private String systemId;

    @KafkaListener(topics = "new-client", groupId = "${kafka.group-id}")
    public void handleClientCreation(ClientMessage message) {
        if (message.getSourceSystem().equals(systemId)) {
            log.debug("Ignoring message from own system");
            return;
        }
        
        try {
            
            Client client = clientMapper.toEntity(message);
            clientRepository.save(client);
        } catch (Exception e) {
            log.error("Failed to process client message", e);
            // Gérer l'erreur selon votre stratégie
        }
    }
}