package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.request.DishRequestDto;
import com.pragma.powerup.application.dto.request.DishUpdateRequestDto;
import com.pragma.powerup.domain.model.DishModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IDishRequestMapper {
    @Mapping(target = "restaurantModel.id", source = "idRestaurantModel")
    DishModel toDishModel(DishRequestDto dishRequestDto);
    DishRequestDto toDishRequestDto(DishModel dishModel);

    DishModel toDishModelUpdate(DishUpdateRequestDto dishUpdateRequestDto);
}
