package com.coderhouse.proyectofinal.commerce.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class WorldClockResponseDTO {
    @JsonAlias("$id")
    private String id;
    private LocalDateTime currentDateTime;
    private String utcOffset;
    private Boolean isDayLightSavingsTime;
    private String dayOfTheWeek;
    private String timeZoneName;
    private Long currentFileTime;
    private String ordinalDate;
    private String serviceResponse;
}
