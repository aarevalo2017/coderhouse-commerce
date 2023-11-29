package com.coderhouse.proyectofinal.commerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
@Table(name = "order_line")
public class OrderLineModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private Integer unitPrice;
    private Integer totalPrice;
    @ManyToOne
    @JoinColumn(name = "order_id")
    @Getter(onMethod = @__(@JsonBackReference))
    private OrderModel order;
    @OneToOne
    private ProductModel product;
}
