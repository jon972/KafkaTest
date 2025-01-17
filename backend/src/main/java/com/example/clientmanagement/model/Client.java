package com.example.clientmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sourceSystem;
    private String externalId;
    private String nom;
    private String prenom;
    private Integer age;
    private LocalDate dateNaissance;
    private String lieuNaissance;
}