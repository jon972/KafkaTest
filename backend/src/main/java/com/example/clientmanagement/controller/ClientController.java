package com.example.clientmanagement.controller;

import com.example.clientmanagement.model.Client;
import com.example.clientmanagement.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Slf4j
public class ClientController {
    private final ClientService clientService;
    private final Environment env;

    @GetMapping
    public List<Client> getAllClients() {
        log.info("Requête getAllClients reçue sur le backend {} - URL BD: {}", 
            env.getProperty("INSTANCE_ID", "backend1"),
            env.getProperty("spring.datasource.url"));
        return clientService.getAllClients();
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }
}