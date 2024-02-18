package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.ICategoryServicePort;
import com.pragma.powerup.domain.model.CategoryModel;
import com.pragma.powerup.domain.spi.ICategoryPersistencePort;

import java.util.List;

public class CategoryUseCase implements ICategoryServicePort {
    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(CategoryModel categoryModel) {
        categoryPersistencePort.saveCategory(categoryModel);
    }

    @Override
    public CategoryModel getCategoryById(Long id) {
        return categoryPersistencePort.getCategoryById(id);
    }

    @Override
    public List<CategoryModel> getAllCategory() {
        return categoryPersistencePort.getAllCategory();
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryPersistencePort.deleteCategoryById(id);
    }
}
