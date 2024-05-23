package com.example.destiny_service.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "destiny_agency")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Destiny {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del destino es obligatorio")
    @Length(max = 255, message = "El nombre del destino no puede tener más de 255 caracteres")
    private String name;

    @NotBlank(message = "La descripción es obligatoria")
    @Length(max = 1000, message = "La descripción no puede tener más de 1000 caracteres")
    private String description;

    @NotNull(message = "El precio es obligatorio")
    @Min(value = 0, message = "El precio no puede ser negativo")
    private Double price;

    @NotBlank(message = "La ubicación es obligatoria")
    @Length(max = 255, message = "La ubicación no puede tener más de 255 caracteres")
    private String place;

    @Override
    public String toString() {
        return "Destiny{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' +
                ", price=" + price + ", place='" + place + '\'' + '}';
    }
}
