package com.coderhouse.proyectofinal.commerce.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ProductNotFoundException(Long productId) {
	super("Product not found by id: " + productId);
	log.info(getMessage());
    }
}
