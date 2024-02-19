package com.pragma.powerup.factory;

import com.pragma.powerup.domain.model.CategoryModel;
import com.pragma.powerup.domain.model.DishModel;
import com.pragma.powerup.domain.model.RestaurantModel;

public class RestaurantTestData {
    public static RestaurantModel getRestaurant(){
        RestaurantModel restaurantModel= new RestaurantModel();
        restaurantModel.setId(1L);
        restaurantModel.setNombre("ulala kayeye");
        restaurantModel.setNit("222221");
        restaurantModel.setDireccion("Calle ulala_ #123");
        restaurantModel.setTelefono("+1234457890");
        restaurantModel.setUrlLogo("https://kayeye.com/dfg.png");
        restaurantModel.setIdPropietario(1L);

        return restaurantModel;
    }

    public static DishModel getDish(){
        DishModel dishModel = new DishModel();
        dishModel.setId(1L);
        dishModel.setNombre("kayeye");
        dishModel.setPrecio("20");
        dishModel.setDescripcion("descripcion");
        dishModel.setUrlImagen("URL");
        dishModel.setEstado(true);
        dishModel.setRestaurantModel(getRestaurant());
        dishModel.setCategoria(getCategory());
        return  dishModel;
    }

    public static DishModel getDish2(){
        DishModel dishModel = new DishModel();
        dishModel.setId(2L);
        dishModel.setNombre("tocomo");
        dishModel.setPrecio("20");
        dishModel.setDescripcion("Este es un major");
        dishModel.setUrlImagen("https://ejemplo.com/imagen.png");
        dishModel.setEstado(true);
        dishModel.setRestaurantModel(getRestaurant());
        dishModel.setCategoria(getCategory());
        return  dishModel;
    }

    public static CategoryModel getCategory(){
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(1L);
        categoryModel.setNombre("Vapor");
        categoryModel.setDescripcion("Comida al humo hahahaa");
        return categoryModel;
    }


}
