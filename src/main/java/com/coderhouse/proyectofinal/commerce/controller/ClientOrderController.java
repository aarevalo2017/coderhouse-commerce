package com.coderhouse.proyectofinal.commerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.proyectofinal.commerce.dto.ClientDTO;
import com.coderhouse.proyectofinal.commerce.service.ClientService;
import com.coderhouse.proyectofinal.commerce.service.OrderService;

@RestController
@RequestMapping("api/v1/client/{clientId}/orders")
public class ClientOrderController extends BaseController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<?> readAllClients(@PathVariable Long clientId) {
	Optional<ClientDTO> opt = clientService.getSingleClient(clientId);
	if (opt.isPresent()) {
	    return ResponseEntity.ok(orderService.getOrdersFromClient(clientId));
	}
	return ResponseEntity.notFound().build();
    }
}
