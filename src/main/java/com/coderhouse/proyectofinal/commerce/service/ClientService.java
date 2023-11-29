package com.coderhouse.proyectofinal.commerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.proyectofinal.commerce.model.ClientModel;
import com.coderhouse.proyectofinal.commerce.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientModel> getAllClients() {
	return clientRepository.findAll();
    }

    public Optional<ClientModel> getSingleClient(Long id) {
	return clientRepository.findById(id);
    }
}
