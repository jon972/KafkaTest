package com.example.clientmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class ClientManagementApplication {
    
    @Autowired
    private Environment env;

    @PostConstruct
    public void logDatabaseInfo() {
        log.info("URL de la base de données : {}", 
            env.getProperty("spring.datasource.url"));
        log.info("Utilisateur de la base de données : {}", 
            env.getProperty("spring.datasource.username"));
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientManagementApplication.class, args);
    }
} 