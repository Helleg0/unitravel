package com.example.fly_service.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Entity
@Table(name = "fly_agency")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Fly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El identificador del avión es obligatorio")
    private int idPlane;

    @NotNull(message = "La fecha del vuelo es obligatoria")
    @Future(message = "La fecha del vuelo debe ser en el futuro")
    private Date dateFly;

    @NotBlank(message = "La ciudad de partida es obligatoria")
    @Length(max = 255, message = "La ciudad de partida no puede tener más de 255 caracteres")
    private String departureCity;

    @NotBlank(message = "La ciudad de llegada es obligatoria")
    @Length(max = 255, message = "La ciudad de llegada no puede tener más de 255 caracteres")
    private String arriveCity;

    @Override
    public String toString() {
        return "Fly{" + "id=" + id + ", idPlane=" + idPlane + ", dateFly=" + dateFly +
                ", departureCity='" + departureCity + '\'' + ", arriveCity='" + arriveCity + '\'' + '}';
    }
}
