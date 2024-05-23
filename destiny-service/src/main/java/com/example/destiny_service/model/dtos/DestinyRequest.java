package com.example.destiny_service.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DestinyRequest {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String place;
}
