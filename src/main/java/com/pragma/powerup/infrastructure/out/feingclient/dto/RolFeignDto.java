package com.pragma.powerup.infrastructure.out.feingclient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolFeignDto {
    private Long id;
    private String nombre;
    private String descripcion;

}
