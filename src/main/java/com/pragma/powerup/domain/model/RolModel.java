package com.pragma.powerup.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolModel {
    private Long id;
    private String nombre;
    private String descripcion;
}
