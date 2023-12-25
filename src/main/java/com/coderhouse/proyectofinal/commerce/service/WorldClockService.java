package com.coderhouse.proyectofinal.commerce.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coderhouse.proyectofinal.commerce.dto.WorldClockResponseDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WorldClockService {

    @Value("${worldClockApi.url}")
    private String worldClockUrl;

    @Autowired
    RestTemplate restTemplate;

    public LocalDateTime requestCurrentDateTime() {
	try {
	    WorldClockResponseDTO response = restTemplate.getForObject(worldClockUrl, WorldClockResponseDTO.class);
	    if (response.getCurrentDateTime() == null && response.getServiceResponse() != null)
		throw new Exception(response.getServiceResponse());
	    log.info("Date/time successfully obtained from WorldClock API: {}", response.getCurrentDateTime());
	    return response.getCurrentDateTime();
	} catch (Exception e) {
	    log.error("Error from worldclockapi with message: '{}', returning system LocalDateTime.", e.getMessage());
	    return LocalDateTime.now();
	}
    }
}
