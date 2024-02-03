package com.pragma.powerup.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishModel {
    private Long id;
    private String nombre;
    private String precio;
    private String descripcion;
    private String urlImagen;
    private String categoria;
    private boolean estado;
    private RestaurantModel restaurantModel;
}

