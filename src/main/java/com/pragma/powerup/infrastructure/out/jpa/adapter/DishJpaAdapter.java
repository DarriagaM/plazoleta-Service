package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.DishModel;
import com.pragma.powerup.domain.spi.IDishPersistencePort;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import com.pragma.powerup.infrastructure.out.jpa.entity.DishEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IDishEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IDishRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class DishJpaAdapter implements IDishPersistencePort {
    private final IDishRepository dishRepository;
    private final IDishEntityMapper dishEntityMapper;


    @Override
    public DishModel saveDishModel(DishModel dishModel) {
        DishEntity dishEntity = dishRepository.save(dishEntityMapper.toDishEntity(dishModel));
        return dishEntityMapper.toDishModel(dishEntity);
    }

    @Override
    public DishModel getDishById(Long id) {
        Optional<DishEntity> dishEntityOptional = dishRepository.findById(id);
        DishEntity dishEntity = dishEntityOptional.orElse(null);
        return dishEntityMapper.toDishModel(dishEntity);
    }

    @Override
    public List<DishModel> getDishModelList() {
        List<DishEntity> dishEntityList = dishRepository.findAll();
        if(dishEntityList.isEmpty()){
            throw  new NoDataFoundException();
        }
        return dishEntityMapper.toDishModelList(dishEntityList);
    }

    @Override
    public void deleteDishById(Long id) {
        dishRepository.deleteById(id);
    }
}
