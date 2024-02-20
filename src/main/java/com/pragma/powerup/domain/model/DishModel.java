package com.pragma.powerup.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishModel {
    private Long id;
    private String nombre;
    private String precio;
    private String descripcion;
    private String urlImagen;
    private boolean estado;
    private CategoryModel categoria;
    private RestaurantModel restaurantModel;
}

