package com.example.book_service.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequest {
    private Long id;
    private String title;
    private String author;
    private Long idAccommodation;
    private Long idDestiny;
    private Long idFly;
    private Long idUser;
}
