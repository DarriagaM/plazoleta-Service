package com.pragma.powerup.application.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class DishUpdateRequestDto {
    @NotBlank()
    @Pattern(regexp = "^[1-9]\\d*$")
    private String precio;

    @NotBlank()
    private String descripcion;
}
