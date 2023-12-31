package com.coderhouse.proyectofinal.commerce.exceptions;

import com.coderhouse.proyectofinal.commerce.model.ProductModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductOutOfStockException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ProductOutOfStockException(ProductModel product) {
	super("Product [" + product.getDescription() + "] does not have enough stock.");
	log.info(getMessage());
    }
}
