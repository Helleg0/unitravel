package com.example.accommodation_service.model.entieties;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "accommodation_agency")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 255, message = "El nombre no puede tener más de 255 caracteres")
    private String name;

    @NotNull(message = "La URL de las fotos es obligatoria")
    @URL(message = "Formato de URL de fotos inválido")
    private String photos;

    @Length(max = 255, message = "La ubicación no puede tener más de 255 caracteres")
    private String location;

    @Min(value = 1, message = "La calificación debe estar entre 1 y 5")
    @Max(value = 5, message = "La calificación debe estar entre 1 y 5")
    private Integer rating;

    @Length(max = 1000, message = "Los comentarios no pueden tener más de 1000 caracteres")
    private String comments;

    private String characteristics;

    @Min(value = 1, message = "La capacidad máxima debe ser de al menos 1")
    private Integer maxCapacity;

    @Min(value = 0, message = "El precio no puede ser negativo")
    @NotNull(message = "El precio es obligatorio")
    private Integer price;

    @Override
    public String toString() {
        return "Accommodation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photos='" + photos + '\'' +
                ", location='" + location + '\'' +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
                ", characteristics='" + characteristics + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", price=" + price +
                '}';
    }
}
