package com.pragma.powerup.application.dto.request;

import com.pragma.powerup.domain.model.RestaurantModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class DishRequestDto {
    @NotBlank
    private String nombre;
    @NotBlank
    @Pattern(regexp = "^[1-9]\\d*$", message = "Precio debe ser mayor a cero")
    private String precio;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String urlImagen;
    @NotBlank
    private String categoria;

    @NotNull
    @Min(value = 1)
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Long idRestaurantModel;
}
