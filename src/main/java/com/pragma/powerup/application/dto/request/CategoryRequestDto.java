package com.pragma.powerup.application.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryRequestDto {
    private String nombre;
    private String descripcion;
}
