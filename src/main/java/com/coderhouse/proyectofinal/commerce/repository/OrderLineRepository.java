package com.coderhouse.proyectofinal.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.proyectofinal.commerce.model.OrderLineModel;

public interface OrderLineRepository extends JpaRepository<OrderLineModel, Long> {

}
