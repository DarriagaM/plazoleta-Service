package com.pragma.powerup.application.dto.request;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class RestaurantRequestDto {
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-zA-Z])[0-9a-zA-Z ]+$", message = "El nombre puede contener números con letras pero no solo números")
    private String nombre;
    @NotBlank
    @Pattern(regexp = "\\d+", message = "El nit debe ser númerico")
    private String nit;
    @NotBlank
    private String direccion;
    @NotBlank
    @Pattern(regexp = "^\\+?\\d{1,12}$", message = "El telefono debe contener máximo 13 caracteres y puede contener el símbolo '+' al inicio")
    private String telefono;
    @NotBlank
    private String urlLogo;
    @NotBlank
    private Long idPropietario;
}
