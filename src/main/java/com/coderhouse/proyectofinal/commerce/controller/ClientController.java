package com.coderhouse.proyectofinal.commerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.proyectofinal.commerce.model.ClientModel;
import com.coderhouse.proyectofinal.commerce.service.ClientService;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<?> readAllClients() {
	return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readSingleClient(@PathVariable Long id) {
	Optional<ClientModel> opt = clientService.getSingleClient(id);
	if (opt.isPresent())
	    return ResponseEntity.ok(opt.get());
	else
	    return ResponseEntity.notFound().build();
    }
}
