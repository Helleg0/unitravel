package com.example.book_service.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "book_agency")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    @Length(max = 255, message = "El título no puede tener más de 255 caracteres")
    private String title;

    @NotBlank(message = "El autor es obligatorio")
    @Length(max = 255, message = "El autor no puede tener más de 255 caracteres")
    private String author;

    // Assuming these are foreign keys referencing other entities
    private Long idAccommodation;
    private Long idDestiny;
    private Long idFly;
    private Long idUser;

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title='" + title + '\'' + ", author='" + author + '\'' +
                ", idAccommodation=" + idAccommodation + ", idDestiny=" + idDestiny +
                ", idFly=" + idFly + ", idUser=" + idUser + '}';
    }
}
