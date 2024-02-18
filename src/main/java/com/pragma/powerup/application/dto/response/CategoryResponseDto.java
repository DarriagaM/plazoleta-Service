package com.pragma.powerup.application.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryResponseDto {
    private Long id;
    private String nombre;
    private String descripcion;
}
