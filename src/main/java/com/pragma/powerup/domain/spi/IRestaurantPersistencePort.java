package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.RestaurantModel;

import java.util.List;

public interface IRestaurantPersistencePort {
    RestaurantModel saveRestaurantModel(RestaurantModel restaurantModel);
    RestaurantModel getRequestRestaurantByIdOwner(Long idOwner);
    RestaurantModel getRestaurantModelById(Long id);
    List<RestaurantModel> getRestaurantModelList();
    void deleteRestaurantModelById(Long id);
    List<RestaurantModel> getRestaurantsWithPagination(Integer page,Integer size);
}
