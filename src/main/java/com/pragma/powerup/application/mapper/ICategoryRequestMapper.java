package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.request.CategoryRequestDto;
import com.pragma.powerup.domain.model.CategoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICategoryRequestMapper {
    CategoryModel toCategoryModel(CategoryRequestDto categoryRequestDto);
    CategoryRequestDto toCategoryRequestDto(CategoryModel categoryModel);
}
