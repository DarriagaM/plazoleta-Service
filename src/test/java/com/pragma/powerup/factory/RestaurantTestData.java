package com.pragma.powerup.factory;

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
}
