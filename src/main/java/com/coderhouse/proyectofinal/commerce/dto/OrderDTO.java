package com.coderhouse.proyectofinal.commerce.dto;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.util.Assert;

import com.coderhouse.proyectofinal.commerce.model.OrderLineModel;
import com.coderhouse.proyectofinal.commerce.model.OrderModel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDTO {

    private Long id;
    private Date date;
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
	return opt.map(e -> OrderDTO.builder().id(e.getId()).client(ClientDTO.build(e.getClient())).date(e.getDate())
		.lines(e.getLines()).build());
    }
}
