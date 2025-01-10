package com.example.clientmanagement.mapper;

import com.example.clientmanagement.model.Client;
import com.example.clientmanagement.model.ClientMessage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client toEntity(ClientMessage message);
} 