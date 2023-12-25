package com.coderhouse.proyectofinal.commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.proyectofinal.commerce.model.ClientModel;
import com.coderhouse.proyectofinal.commerce.service.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/client")
public class ClientController extends BaseController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<?> readAllClients() {
	return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readSingleClient(@PathVariable Long id) {
	return ResponseEntity.of(clientService.getSingleClient(id));
    }

    @PostMapping
    public ResponseEntity<?> addNewClient(@Valid @RequestBody ClientModel client) {
	return ResponseEntity.status(HttpStatus.CREATED).body(clientService.create(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
	boolean response = clientService.delete(id);
	return ResponseEntity.status(response ? HttpStatus.OK : HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@PathVariable Long id, @RequestBody ClientModel client) {
	boolean response = clientService.update(id, client);
	return ResponseEntity.status(response ? HttpStatus.OK : HttpStatus.NOT_FOUND).build();
    }
}
