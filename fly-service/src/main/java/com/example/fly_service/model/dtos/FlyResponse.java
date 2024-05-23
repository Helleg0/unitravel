package com.example.fly_service.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlyResponse {
    private Long id;
    private int id_plane;
    private Date date_fly;
    private String departure_city;
    private String arrive_city;
}
