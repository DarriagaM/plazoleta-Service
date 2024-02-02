package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IRestaurantServicePort;
import com.pragma.powerup.domain.model.RestaurantModel;
import com.pragma.powerup.domain.spi.IRestaurantPersistencePort;

import java.util.List;

public class RestaurantUseCase implements IRestaurantServicePort {
    private final IRestaurantPersistencePort restaurantPersistencePort;

    public RestaurantUseCase(IRestaurantPersistencePort restaurantPersistencePort) {

        this.restaurantPersistencePort = restaurantPersistencePort;
    }

    @Override
    public void saveRestaurant(RestaurantModel restaurantModel) {
        restaurantPersistencePort.saveRestaurantModel(restaurantModel);
    }

    @Override
    public RestaurantModel getRestaurantModelById(Long id) {
        return restaurantPersistencePort.getRestaurantModelById(id);
    }

    @Override
    public List<RestaurantModel> getAllRestaurantModelList() {
        return restaurantPersistencePort.getRestaurantModelList();
    }

    @Override
    public void deleteRestaurantById(Long id) {
        restaurantPersistencePort.deleteRestaurantModelById(id);
    }
}
