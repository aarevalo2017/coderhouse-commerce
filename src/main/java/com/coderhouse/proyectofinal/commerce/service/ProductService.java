package com.coderhouse.proyectofinal.commerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.proyectofinal.commerce.model.OrderLineModel;
import com.coderhouse.proyectofinal.commerce.model.ProductModel;
import com.coderhouse.proyectofinal.commerce.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> getAllProducts() {
	return productRepository.findAll();
    }

    public Optional<ProductModel> getSingleProduct(Long id) {
	return productRepository.findById(id);
    }

    public ProductModel create(ProductModel product) {
	return productRepository.save(product);
    }

    public void reduceStock(OrderLineModel orderLine) {
	ProductModel p = productRepository.findById(orderLine.getProductId()).get();
	p.setStock(p.getStock() - orderLine.getQuantity());
	productRepository.save(p);
    }

    public boolean update(Long id, ProductModel product) {
	Optional<ProductModel> opt = getSingleProduct(id);
	if (opt.isPresent()) {
	    product.setId(id);
	    productRepository.save(product);
	    return true;
	}
	return false;
    }
}
