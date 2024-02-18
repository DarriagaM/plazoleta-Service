package com.pragma.powerup.application.dto.response;

import com.pragma.powerup.domain.model.CategoryModel;
import com.pragma.powerup.domain.model.RestaurantModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DishResponseDto {
    private Long id;
    private String nombre;
    private String precio;
    private String descripcion;
    private String urlImagen;
    private CategoryModel categoria;
    private boolean estado;
    private RestaurantModel restaurantModel;
}
