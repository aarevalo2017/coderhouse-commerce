package com.coderhouse.proyectofinal.commerce.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.coderhouse.proyectofinal.commerce.dto.OrderDTO;
import com.coderhouse.proyectofinal.commerce.exceptions.ClientNotFoundException;
import com.coderhouse.proyectofinal.commerce.exceptions.ProductNotFoundException;
import com.coderhouse.proyectofinal.commerce.exceptions.ProductOutOfStockException;
import com.coderhouse.proyectofinal.commerce.model.ClientModel;
import com.coderhouse.proyectofinal.commerce.model.OrderLineModel;
import com.coderhouse.proyectofinal.commerce.model.OrderModel;
import com.coderhouse.proyectofinal.commerce.model.ProductModel;
import com.coderhouse.proyectofinal.commerce.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    @Autowired
    private WorldClockService worldClockService;

    public List<OrderDTO> getAllOrders() {
	return OrderDTO.of(orderRepository.findAll());
    }

    public Optional<OrderDTO> getSingleOrder(Long id) {
	return OrderDTO.of(orderRepository.findById(id));
    }

    public List<OrderModel> getOrdersFromClient(Long clientId) {
	return orderRepository.findByClientId(clientId);
    }

    public Optional<OrderDTO> create(OrderDTO order) {
	Assert.notNull(order, "Order must not be null");
	log.info("New order requested: {}", order.toString());

	// Client validation
	ClientModel client = clientService.getClientModel(order.getClient().getId())
		.orElseThrow(() -> new ClientNotFoundException(order.getClient()));
	log.info("Client found with: {}", client);
	OrderModel newOrder = OrderModel.builder().client(client).build();

	// Product and inventory validation
	List<OrderLineModel> lines = order.getLines().stream().map(l -> {
	    ProductModel product = productService.getSingleProduct(l.getProductId())
		    .orElseThrow(() -> new ProductNotFoundException(l.getProductId()));
	    log.info("Product found: {}", product);
	    if (product.getStock() < l.getQuantity())
		throw new ProductOutOfStockException(product);
	    log.info("Product [{}] inventory: {} units", product.getSku(), product.getStock());
	    return OrderLineModel.builder()
		    .productDescription(product.getDescription())
		    .productId(product.getId())
		    .quantity(l.getQuantity())
		    .totalPrice(product.getPrice() * l.getQuantity())
		    .unitPrice(product.getPrice())
		    .order(newOrder)
		    .build();
	}).collect(Collectors.toList());
	newOrder.setLines(lines);
	newOrder.setDate(worldClockService.requestCurrentDateTime());
	OrderModel storedOrder = orderRepository.save(newOrder);
	storedOrder.getLines().forEach(productService::reduceStock);
	log.info("New Order created with id: {}", storedOrder.getId());
	return Optional.of(OrderDTO.buildFromModel(storedOrder));
    }
}
