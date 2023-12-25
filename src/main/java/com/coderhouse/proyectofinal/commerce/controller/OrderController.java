package com.coderhouse.proyectofinal.commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.proyectofinal.commerce.dto.OrderDTO;
import com.coderhouse.proyectofinal.commerce.service.OrderService;

@RestController
@RequestMapping("api/v1/order")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<?> readAllOrders() {
	return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readSingleOrder(@PathVariable Long id) {
	return ResponseEntity.of(orderService.getSingleOrder(id));
    }

    @PostMapping
    public ResponseEntity<?> postMethodName(@RequestBody OrderDTO order) {
	return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(order));
    }
}
