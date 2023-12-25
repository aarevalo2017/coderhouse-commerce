package com.coderhouse.proyectofinal.commerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.proyectofinal.commerce.model.ProductModel;
import com.coderhouse.proyectofinal.commerce.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/product")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> readAllProducts() {
	return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readSingleProduct(@PathVariable Long id) {
	Optional<ProductModel> opt = productService.getSingleProduct(id);
	if (opt.isPresent())
	    return ResponseEntity.ok(opt.get());
	else
	    return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> addNewProduct(@Valid @RequestBody ProductModel product) {
	return ResponseEntity.ok(productService.create(product));
    }
}
