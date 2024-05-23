package com.example.accommodation_service.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AccommodationResponse {
    private Long id;
    private String name;
    private String photos;
    private String location;
    private Integer rating;
    private String comments;
    private String characteristics;
    private Integer maxCapacity;
    private Integer price;
}
