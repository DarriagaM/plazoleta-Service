package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.RestaurantModel;

import java.util.List;

public interface IRestaurantServicePort {
    void saveRestaurant(RestaurantModel restaurantModel);
    RestaurantModel getRestaurantModelById(Long id);
    List<RestaurantModel> getAllRestaurantModelList();
    void deleteRestaurantById(Long id);

}
