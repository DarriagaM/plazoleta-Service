package com.pragma.powerup.domain;

import com.pragma.powerup.domain.api.ICategoryServicePort;
import com.pragma.powerup.domain.exception.DomainException;
import com.pragma.powerup.domain.model.CategoryModel;
import com.pragma.powerup.domain.model.DishModel;
import com.pragma.powerup.domain.model.RestaurantModel;
import com.pragma.powerup.domain.spi.IDishPersistencePort;
import com.pragma.powerup.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.domain.spi.token.IToken;
import com.pragma.powerup.domain.usecase.DishUseCase;
import com.pragma.powerup.factory.RestaurantTestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
class DishUseCaseTest {
    @InjectMocks
    DishUseCase dishUseCase;

    @Mock
    IDishPersistencePort dishPersistencePort;


    @Mock
    IRestaurantPersistencePort restaurantPersistencePort;

    @Mock
    private IToken token;

    @Mock
    private ICategoryServicePort categoryServicePort;

    @Test
    void mustSaveDish() {
        RestaurantModel restaurantModel = RestaurantTestData.getRestaurant();
        CategoryModel categoryModel = RestaurantTestData.getCategory();
        DishModel dishModel = RestaurantTestData.getDish();


        Mockito.when(restaurantPersistencePort.getRestaurantModelById(dishModel.getRestaurantModel().getId())).thenReturn(restaurantModel);
        Mockito.when(categoryServicePort.getCategoryById(dishModel.getRestaurantModel().getId())).thenReturn(categoryModel);
        Mockito.when(token.getBearerToken()).thenReturn("Bearer Token");
        Mockito.when(token.getId("Bearer Token")).thenReturn(1L);

        dishUseCase.saveDishModel(dishModel);

        Mockito.verify(dishPersistencePort).saveDishModel(dishModel);
    }


    @Test
    void saveDishInvalidRestaurant() {
        RestaurantModel restaurantModel = RestaurantTestData.getRestaurant();
        CategoryModel categoryModel = RestaurantTestData.getCategory();
        DishModel dishModel = RestaurantTestData.getDish();

        Mockito.when(restaurantPersistencePort.getRestaurantModelById(restaurantModel.getId())).thenReturn(null);
        Mockito.when(categoryServicePort.getCategoryById(categoryModel.getId())).thenReturn(categoryModel);

        assertThrows(DomainException.class, () -> dishUseCase.saveDishModel(dishModel));
    }

    @Test
    void saveDishInvalidCategory() {
        RestaurantModel restaurantModel= RestaurantTestData.getRestaurant();
        CategoryModel categoryModel = RestaurantTestData.getCategory();
        DishModel dishModel = RestaurantTestData.getDish();

        Mockito.when(restaurantPersistencePort.getRestaurantModelById(restaurantModel.getId())).thenReturn(restaurantModel);
        Mockito.when(categoryServicePort.getCategoryById(categoryModel.getId())).thenReturn(null);

        assertThrows(DomainException.class, () -> dishUseCase.saveDishModel(dishModel));
    }

    @Test
    void mustUpdateDish() {
        DishModel dishModel = RestaurantTestData.getDish();
        DishModel dishModel2 = RestaurantTestData.getDish2();
        RestaurantModel restaurantModel = RestaurantTestData.getRestaurant();

        Mockito.when(dishPersistencePort.getDishById(dishModel.getId())).thenReturn(dishModel2);
        Mockito.when(token.getBearerToken()).thenReturn("Bearer Token");
        Mockito.when(token.getId("Bearer Token")).thenReturn(1L);
        Mockito.when(restaurantPersistencePort.getRestaurantModelById(dishModel2.getRestaurantModel().getId())).thenReturn(restaurantModel);

        dishUseCase.updateDish(dishModel.getId(), dishModel);

        Mockito.verify(dishPersistencePort, Mockito.times(1)).saveDishModel(dishModel2);
        assertEquals(dishModel.getDescripcion(), dishModel2.getDescripcion());
        assertEquals(dishModel.getPrecio(), dishModel2.getPrecio());
    }

    @Test
    void mustSetOnOff() {
        DishModel dishModel = RestaurantTestData.getDish();
        RestaurantModel restaurantModel = RestaurantTestData.getRestaurant();
        boolean activeOrInactive = false;

        Mockito.when(dishPersistencePort.getDishById(1L)).thenReturn(dishModel);
        Mockito.when(token.getBearerToken()).thenReturn("Bearer Token");
        Mockito.when(token.getId("Bearer Token")).thenReturn(1L);
        Mockito.when(restaurantPersistencePort.getRestaurantModelById(dishModel.getRestaurantModel().getId())).thenReturn(restaurantModel);

        dishUseCase.setOnOff(dishModel.getId(), activeOrInactive);


        Mockito.verify(dishPersistencePort, Mockito.times(1)).saveDishModel(dishModel);
        assertEquals(false, dishModel.isEstado());
    }



}
