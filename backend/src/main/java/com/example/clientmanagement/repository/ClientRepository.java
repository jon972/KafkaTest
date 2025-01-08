package com.example.clientmanagement.repository;

import com.example.clientmanagement.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}