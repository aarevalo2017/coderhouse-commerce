package com.coderhouse.proyectofinal.commerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.proyectofinal.commerce.model.OrderLineModel;
import com.coderhouse.proyectofinal.commerce.repository.OrderLineRepository;

@Service
public class OrderLineService {

    @Autowired
    private OrderLineRepository orderLineRepository;

    public List<OrderLineModel> getAllOrderLines() {
	return orderLineRepository.findAll();
    }
}
