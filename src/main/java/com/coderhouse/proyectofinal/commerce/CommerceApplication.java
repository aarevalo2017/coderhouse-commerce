package com.coderhouse.proyectofinal.commerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.proyectofinal.commerce.repository.ClientRepository;
import com.coderhouse.proyectofinal.commerce.repository.OrderRepository;

@SpringBootApplication
public class CommerceApplication implements CommandLineRunner {

    public static void main(String[] args) {
	SpringApplication.run(CommerceApplication.class, args);
    }

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
	System.out.println("**** Application Started ****");
	System.out.println(orderRepository.findAll());
    }
}
