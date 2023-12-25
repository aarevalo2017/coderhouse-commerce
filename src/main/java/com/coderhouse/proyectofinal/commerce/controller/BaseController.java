package com.coderhouse.proyectofinal.commerce.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Builder;
import lombok.Data;

public abstract class BaseController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ValidationError> handleValidationExceptions(MethodArgumentNotValidException ex) {
	return ex.getBindingResult().getAllErrors().stream().map(e -> {
	    String fieldName = ((FieldError) e).getField();
	    String rejectedValue = ((FieldError) e).getRejectedValue().toString();
	    String errorMessage = e.getDefaultMessage();
	    return ValidationError.builder().fieldName(fieldName).errorMessage(errorMessage)
		    .rejectedValue(rejectedValue).build();
	}).collect(Collectors.toList());
    }

    @Data
    @Builder
    static class ValidationError {
	private String fieldName;
	private String rejectedValue;
	private String errorMessage;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String, String> handleIllegalArgumentException(IllegalArgumentException e) {
	return Map.of("message", e.getMessage());
    }
}
