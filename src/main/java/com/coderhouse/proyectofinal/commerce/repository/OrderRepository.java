package com.coderhouse.proyectofinal.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.proyectofinal.commerce.model.OrderModel;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {

}
