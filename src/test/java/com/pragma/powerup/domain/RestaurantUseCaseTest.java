package com.pragma.powerup.domain;

import com.pragma.powerup.domain.model.RestaurantModel;
import com.pragma.powerup.domain.model.RolModel;
import com.pragma.powerup.domain.model.UserModel;
import com.pragma.powerup.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.domain.spi.feignclient.IUserFeignPort;
import com.pragma.powerup.domain.usecase.RestaurantUseCase;
import com.pragma.powerup.factory.RestaurantTestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class RestaurantUseCaseTest {

    @InjectMocks
    RestaurantUseCase restaurantUseCase;

    @Mock
    IRestaurantPersistencePort restaurantPersistencePort;

    @Mock
    IUserFeignPort userFeignPort;

    @Test
    void mustSaveARestaurant() {
        RestaurantModel restaurantModel= RestaurantTestData.getRestaurant();

        UserModel userModel = new UserModel();
        userModel.setRol(new RolModel(3L,"PROPIETARIO", "User al sistena, como Uribe a colombia"));

        Mockito.when(userFeignPort.existsUserById(restaurantModel.getIdPropietario())).thenReturn(true);
        Mockito.when(userFeignPort.getUserById(restaurantModel.getIdPropietario())).thenReturn(userModel);
        Mockito.when(restaurantPersistencePort.getRequestRestaurantByIdOwner(userModel.getId())).thenReturn(null);

        restaurantUseCase.saveRestaurant(restaurantModel);

        Mockito.verify(restaurantPersistencePort).saveRestaurantModel(Mockito.any(RestaurantModel.class));

        ArgumentCaptor<RestaurantModel> argument = ArgumentCaptor.forClass(RestaurantModel.class);
        Mockito.verify(restaurantPersistencePort, Mockito.times(1)).saveRestaurantModel(argument.capture());

        RestaurantModel restaurantModelSaved = argument.getValue();

        assertEquals(restaurantModelSaved.getNit(), restaurantModel.getNit());
        assertEquals(restaurantModelSaved.getIdPropietario(), restaurantModel.getIdPropietario());
    }
}
