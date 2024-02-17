package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IRestaurantServicePort;
import com.pragma.powerup.domain.exception.DomainException;
import com.pragma.powerup.domain.model.RestaurantModel;
import com.pragma.powerup.domain.model.UserModel;
import com.pragma.powerup.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.domain.spi.feignclient.IUserFeignPort;

import java.util.List;

public class RestaurantUseCase implements IRestaurantServicePort {
    private final IRestaurantPersistencePort restaurantPersistencePort;
    private final IUserFeignPort userFeignPort;

    public RestaurantUseCase(IRestaurantPersistencePort restaurantPersistencePort, IUserFeignPort userFeignPort) {
        this.restaurantPersistencePort = restaurantPersistencePort;
        this.userFeignPort = userFeignPort;
    }

    @Override
    public void saveRestaurant(RestaurantModel restaurantModel) {
        if(!userFeignPort.existsUserById(restaurantModel.getIdPropietario())){
            throw  new DomainException("Usuario no existe");
        }
        UserModel userModel = userFeignPort.getUserById(restaurantModel.getIdPropietario());
        if(!userModel.getRol().getNombre().equals("PROPIETARIO")){
            throw new DomainException("Usuario debe ser propietario");
        }
        restaurantPersistencePort.saveRestaurantModel(restaurantModel);
    }

    @Override
    public RestaurantModel getRequestRestaurantByIdOwner(Long idOwner) {
        return restaurantPersistencePort.getRequestRestaurantByIdOwner(idOwner);
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
