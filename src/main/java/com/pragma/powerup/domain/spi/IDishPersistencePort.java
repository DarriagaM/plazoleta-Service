package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.DishModel;

import java.util.List;

public interface IDishPersistencePort {
    DishModel saveDishModel(DishModel dishModel);
    DishModel getDishById(Long id);
    List<DishModel> getDishModelList();
    void deleteDishById(Long id);
}
