package com.coderhouse.proyectofinal.commerce.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name = "clients")
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 255)
    private String name;

    @NotBlank
    @Size(min = 2, max = 255)
    private String lastName;

    @NotBlank
    @Size(min = 2, max = 20)
    private String dni;

    @Exclude
    @Getter(onMethod = @__(@JsonManagedReference))
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderModel> orders;
}
