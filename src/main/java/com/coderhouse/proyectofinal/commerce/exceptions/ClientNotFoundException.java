package com.coderhouse.proyectofinal.commerce.exceptions;

import com.coderhouse.proyectofinal.commerce.dto.ClientDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ClientNotFoundException(ClientDTO client) {
	super("Client not found by id: " + client.getId());
	log.info(getMessage());
    }
}
