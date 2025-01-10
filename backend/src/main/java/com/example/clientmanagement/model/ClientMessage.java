package com.example.clientmanagement.model;

import java.time.LocalDate;
import lombok.Data;

@Data
public class ClientMessage {
    private Long id;
    private String sourceSystem;
    private String externalId;
    private String nom;
    private String prenom;
    private Integer age;
    private LocalDate dateNaissance;
    private String lieuNaissance;
} 