package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IDishServicePort;
import com.pragma.powerup.domain.exception.DomainException;
import com.pragma.powerup.domain.model.DishModel;
import com.pragma.powerup.domain.spi.IDishPersistencePort;
import com.pragma.powerup.domain.spi.IRestaurantPersistencePort;

import java.util.List;

public class DishUseCase implements IDishServicePort {
    private final IDishPersistencePort dishPersistencePort;
    private final IRestaurantPersistencePort restaurantPersistencePort;

    public DishUseCase(IDishPersistencePort dishPersistencePort, IRestaurantPersistencePort restaurantPersistencePort) {
        this.dishPersistencePort = dishPersistencePort;
        this.restaurantPersistencePort = restaurantPersistencePort;
    }

    @Override
    public void saveDishModel(DishModel dishModel) {
        if(restaurantPersistencePort.getRestaurantModelById(dishModel.getRestaurantModel().getId()) == null){
            throw  new DomainException("Restaurante no existe");
        }
        dishModel.setEstado(true);
        dishPersistencePort.saveDishModel(dishModel);
    }

    @Override
    public DishModel getDishById(Long id) {
        return dishPersistencePort.getDishById(id);
    }

    @Override
    public List<DishModel> getADishModelList() {
        return dishPersistencePort.getDishModelList();
    }

    @Override
    public void deleteDishById(Long id) {
        dishPersistencePort.deleteDishById(id);
    }
}
