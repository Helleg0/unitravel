package com.example.user_service.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "user_agency")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El identificador del rol es obligatorio")
    private int idRol;

    @NotBlank(message = "El nombre es obligatorio")
    @Length(max = 255, message = "El nombre no puede tener más de 255 caracteres")
    private String name;

    @NotBlank(message = "El documento de identidad es obligatorio")
    @Length(max = 255, message = "El documento de identidad no puede tener más de 255 caracteres") // Adjust max length as needed
    private String document;

    @NotBlank(message = "La dirección es obligatoria")
    @Length(max = 255, message = "La dirección no puede tener más de 255 caracteres")
    private String address;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "^[\\+]?[0-9]*$", message = "El teléfono debe ser un número válido")  // Adjust regexp for your phone number format
    private String phone;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", idRol=" + idRol + ", name='" + name + '\'' +
                ", document='" + document + '\'' + ", address='" + address + '\'' +
                ", phone='" + phone + '\'' + '}';
    }
}
