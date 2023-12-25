package com.coderhouse.proyectofinal.commerce.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.proyectofinal.commerce.dto.OrderDTO;
import com.coderhouse.proyectofinal.commerce.exceptions.ClientNotFoundException;
import com.coderhouse.proyectofinal.commerce.exceptions.ProductNotFoundException;
import com.coderhouse.proyectofinal.commerce.exceptions.ProductOutOfStockException;
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
	return ResponseEntity.of(orderService.getSingleOrder(id));
    }

    @PostMapping
    public ResponseEntity<?> postMethodName(@RequestBody OrderDTO order) {
	return ResponseEntity.of(orderService.create(order));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProductNotFoundException.class)
    public Map<String, String> handleIllegalArgumentException(ProductNotFoundException e) {
	return Map.of("errorMessage", e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProductOutOfStockException.class)
    public Map<String, String> handleProductNoStockException(ProductOutOfStockException e) {
	return Map.of("errorMessage", e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ClientNotFoundException.class)
    public Map<String, String> handleClientNotFoundException(ClientNotFoundException e) {
	return Map.of("errorMessage", e.getMessage());
    }
}
