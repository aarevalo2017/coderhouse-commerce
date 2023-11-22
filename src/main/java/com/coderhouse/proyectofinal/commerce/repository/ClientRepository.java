package com.coderhouse.proyectofinal.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.proyectofinal.commerce.model.ClientModel;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {

}
