package com.coderhouse.proyectofinal.commerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "order_line")
public class OrderLineModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;
    private Integer unitPrice;
    private Integer totalPrice;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderModel order;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductModel product;
}
