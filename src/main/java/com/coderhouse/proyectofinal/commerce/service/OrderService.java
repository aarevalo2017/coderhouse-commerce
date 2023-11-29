package com.coderhouse.proyectofinal.commerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.proyectofinal.commerce.model.OrderModel;
import com.coderhouse.proyectofinal.commerce.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderModel> getAllOrders() {
	return orderRepository.findAll();
    }

    public Optional<OrderModel> getSingleOrder(Long id) {
	return orderRepository.findById(id);
    }
}
