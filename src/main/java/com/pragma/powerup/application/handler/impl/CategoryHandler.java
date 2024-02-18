package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.CategoryRequestDto;
import com.pragma.powerup.application.dto.response.CategoryResponseDto;
import com.pragma.powerup.application.handler.ICategoryHandler;
import com.pragma.powerup.application.mapper.ICategoryRequestMapper;
import com.pragma.powerup.application.mapper.ICategoryResponseMapper;
import com.pragma.powerup.domain.api.ICategoryServicePort;
import com.pragma.powerup.domain.model.CategoryModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class CategoryHandler implements ICategoryHandler {
    private final ICategoryServicePort categoryServicePort;
    private final ICategoryRequestMapper categoryRequestMapper;
    private final ICategoryResponseMapper categoryResponseMapper;

    @Override
    public void saveCategory(CategoryRequestDto categoryRequestDto) {
        CategoryModel categoryModel = categoryRequestMapper.toCategoryModel(categoryRequestDto);
        categoryServicePort.saveCategory(categoryModel);
    }

    @Override
    public CategoryResponseDto getCategoryById(Long id) {
        CategoryModel categoryModel = categoryServicePort.getCategoryById(id);
        return categoryResponseMapper.toCategoryResponseDto(categoryModel);
    }

    @Override
    public List<CategoryResponseDto> getAllCategory() {
        List<CategoryModel> categoryModelList = categoryServicePort.getAllCategory();
        return categoryResponseMapper.toCategoryResponseDtoList(categoryModelList);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryServicePort.deleteCategoryById(id);
    }
}
