package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.DishModel;

import java.util.List;

public interface IDishServicePort {
    void saveDishModel(DishModel dishModel);
    DishModel getDishById(Long id);
    List<DishModel> getADishModelList();
    void deleteDishById(Long id);
    void updateDish(Long idDish, DishModel dishModel);
}
