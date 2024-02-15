package com.pragma.powerup.infrastructure.out.jpa.mapper;

import com.pragma.powerup.domain.model.DishModel;
import com.pragma.powerup.infrastructure.out.jpa.entity.DishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IDishEntityMapper {
    @Mapping(target = "restaurantModel.id", source = "idRestaurantModel.id")
    DishModel toDishModel(DishEntity dishEntity);

    @Mapping(target = "idRestaurantModel.id", source = "restaurantModel.id")
    DishEntity toDishEntity(DishModel dishModel);
    List<DishModel> toDishModelList(List<DishEntity> dishEntityList);
}
