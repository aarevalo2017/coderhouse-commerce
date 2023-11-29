package com.coderhouse.proyectofinal.commerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.proyectofinal.commerce.model.OrderModel;
import com.coderhouse.proyectofinal.commerce.service.OrderService;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<?> readAllOrders() {
	return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readSingleOrder(@PathVariable Long id) {
	Optional<OrderModel> opt = orderService.getSingleOrder(id);
	if (opt.isPresent())
	    return ResponseEntity.ok(opt.get());
	else
	    return ResponseEntity.notFound().build();
    }
}
