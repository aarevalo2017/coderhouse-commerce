package com.coderhouse.proyectofinal.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.proyectofinal.commerce.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

}
