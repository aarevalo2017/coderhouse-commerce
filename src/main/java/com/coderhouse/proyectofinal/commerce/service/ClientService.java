package com.coderhouse.proyectofinal.commerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.proyectofinal.commerce.dto.ClientDTO;
import com.coderhouse.proyectofinal.commerce.model.ClientModel;
import com.coderhouse.proyectofinal.commerce.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientDTO> getAllClients() {
	return ClientDTO.of(clientRepository.findAll());
    }

    public Optional<ClientDTO> getSingleClient(Long id) {
	return ClientDTO.of(clientRepository.findById(id));
    }

    public Optional<ClientModel> getClientModel(Long id) {
	return clientRepository.findById(id);
    }

    public ClientModel create(ClientModel client) {
	return clientRepository.save(client);
    }

    public boolean delete(Long id) {
	Optional<ClientModel> opt = clientRepository.findById(id);
	if (opt.isPresent()) {
	    clientRepository.delete(opt.get());
	    return true;
	}
	return false;
    }

    public boolean update(Long id, ClientModel client) {
	Optional<ClientDTO> opt = getSingleClient(id);
	if (opt.isPresent()) {
	    client.setId(id);
	    clientRepository.save(client);
	    return true;
	}
	return false;
    }
}
