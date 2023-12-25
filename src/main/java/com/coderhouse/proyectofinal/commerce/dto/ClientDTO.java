package com.coderhouse.proyectofinal.commerce.dto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.coderhouse.proyectofinal.commerce.model.ClientModel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDTO {

    private Long id;
    private String name;
    private String lastName;
    private String dni;

    public static Optional<ClientDTO> of(Optional<ClientModel> optClient) {
	return optClient.map(ClientDTO::build);
//	if (optClient.isPresent()) {
//	    ClientModel c = optClient.get();
//	    return Optional.of(build(c));
//	}
//	return Optional.empty();
    }

    public static List<ClientDTO> of(List<ClientModel> clients) {
	return clients.stream().map(ClientDTO::build).collect(Collectors.toList());
    }

    public static ClientDTO build(ClientModel c) {
	return builder().dni(c.getDni()).id(c.getId()).lastName(c.getLastName()).name(c.getName()).build();
    }
}
