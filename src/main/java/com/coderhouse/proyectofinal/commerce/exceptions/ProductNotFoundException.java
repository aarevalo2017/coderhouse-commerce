package com.coderhouse.proyectofinal.commerce.exceptions;

import com.coderhouse.proyectofinal.commerce.model.ProductModel;

public class ProductNotFoundException extends RuntimeException /* implements ErrorResponse */ {

    private static final long serialVersionUID = 1L;

    public ProductNotFoundException(ProductModel product) {
	super("Product not found by id: " + product.getId());
    }
}
