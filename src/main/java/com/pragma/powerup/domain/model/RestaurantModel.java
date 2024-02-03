package com.pragma.powerup.domain.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantModel {
    private Long id;
    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;
    private String urlLogo;
    private Long idPropietario;

}
