package com.pragma.powerup.infrastructure.out.jpa.mapper;

import com.pragma.powerup.domain.model.DishModel;
import com.pragma.powerup.infrastructure.out.jpa.entity.DishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IDishEntityMapper {
    DishModel toDishModel(DishEntity dishEntity);
    DishEntity toDishEntity(DishModel dishModel);
    List<DishModel> toDishModelList(List<DishEntity> dishEntityList);
}
