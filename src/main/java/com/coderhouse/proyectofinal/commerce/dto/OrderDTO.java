package com.coderhouse.proyectofinal.commerce.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.util.Assert;

import com.coderhouse.proyectofinal.commerce.model.OrderLineModel;
import com.coderhouse.proyectofinal.commerce.model.OrderModel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDTO {

    private Long id;
    private LocalDateTime date;
    private ClientDTO client;
    private List<OrderLineModel> lines;

    public Double getTotal() {
	return lines.stream().mapToDouble(l -> l.getTotalPrice().doubleValue()).sum();
    }

    public Integer getTotalOfProducts() {
	return lines.stream().mapToInt(l -> l.getQuantity()).sum();
    }

    public static Optional<OrderDTO> of(Optional<OrderModel> opt) {
	Assert.notNull(opt, "Order must not be null");
	return opt.map(OrderDTO::buildFromModel);
    }

    public static List<OrderDTO> of(List<OrderModel> orders) {
	return orders.stream().map(OrderDTO::buildFromModel).collect(Collectors.toList());
    }

    public static OrderDTO buildFromModel(OrderModel orderModel) {
	return builder().id(orderModel.getId()).client(ClientDTO.build(orderModel.getClient()))
		.date(orderModel.getDate()).lines(orderModel.getLines()).build();
    }
}
