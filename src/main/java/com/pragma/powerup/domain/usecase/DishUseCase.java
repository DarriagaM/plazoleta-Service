package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IDishServicePort;
import com.pragma.powerup.domain.exception.DomainException;
import com.pragma.powerup.domain.model.DishModel;
import com.pragma.powerup.domain.model.RestaurantModel;
import com.pragma.powerup.domain.spi.IDishPersistencePort;
import com.pragma.powerup.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.domain.spi.token.IToken;

import java.util.List;

public class DishUseCase implements IDishServicePort {
    private final IDishPersistencePort dishPersistencePort;
    private final IRestaurantPersistencePort restaurantPersistencePort;
    private final IToken token;

    public DishUseCase(IDishPersistencePort dishPersistencePort, IRestaurantPersistencePort restaurantPersistencePort, IToken token) {
        this.dishPersistencePort = dishPersistencePort;
        this.restaurantPersistencePort = restaurantPersistencePort;
        this.token = token;
    }

    @Override
    public void saveDishModel(DishModel dishModel) {

        if(restaurantPersistencePort.getRestaurantModelById(dishModel.getRestaurantModel().getId()) == null){
            throw  new DomainException("Restaurante no existe");
        }
        validateUserOwnerRestaurant(dishModel.getRestaurantModel().getId(),"Solo el propietario puede crear platos");

        dishModel.setEstado(true);
        dishPersistencePort.saveDishModel(dishModel);
    }

    public void validateUserOwnerRestaurant(Long idRestaurant, String message){
        RestaurantModel restaurantModel = restaurantPersistencePort.getRestaurantModelById(idRestaurant);
        String bearerToken = token.getBearerToken();
        Long userAutenticatedId = token.getId(bearerToken);
        if(! (restaurantModel.getIdPropietario() == userAutenticatedId)){
            throw new DomainException(message);
        }
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

    @Override
    public void updateDish(Long idDish, DishModel dishModel) {
        DishModel dishModelToUpdate = dishPersistencePort.getDishById(idDish);

        if(dishModelToUpdate == null){
            throw new DomainException("no plato con el id");
        }
        validateUserOwnerRestaurant(dishModelToUpdate.getRestaurantModel().getId()
                                    ,"solo el propietario puede actualizar platos");

        dishModelToUpdate.setPrecio(dishModel.getPrecio());
        dishModelToUpdate.setDescripcion((dishModel.getDescripcion()));
        dishPersistencePort.saveDishModel(dishModelToUpdate);
    }
}
