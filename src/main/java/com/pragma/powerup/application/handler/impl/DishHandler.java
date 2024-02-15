package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.DishRequestDto;
import com.pragma.powerup.application.dto.request.DishUpdateRequestDto;
import com.pragma.powerup.application.dto.response.DishResponseDto;
import com.pragma.powerup.application.handler.IDishHandler;
import com.pragma.powerup.application.mapper.IDishRequestMapper;
import com.pragma.powerup.application.mapper.IDishResponseMapper;
import com.pragma.powerup.domain.api.IDishServicePort;
import com.pragma.powerup.domain.model.DishModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DishHandler implements IDishHandler {
    private final IDishServicePort dishServicePort;
    private final IDishRequestMapper dishRequestMapper;
    private final IDishResponseMapper dishResponseMapper;

    @Override
    public void saveDish(DishRequestDto dishRequestDto) {
        DishModel dishModel = dishRequestMapper.toDishModel(dishRequestDto);
        dishServicePort.saveDishModel(dishModel);
    }

    @Override
    public DishResponseDto getDishById(Long id) {
        DishModel dishModel = dishServicePort.getDishById(id);
        return dishResponseMapper.toDishResponseDto(dishModel);
    }

    @Override
    public List<DishResponseDto> getDishResponseDtoList() {
        List<DishModel> dishModelList = dishServicePort.getADishModelList();
        return dishResponseMapper.toDishResponseDtoList(dishModelList);
    }

    @Override
    public void deleteDish(Long id) {
        dishServicePort.deleteDishById(id);
    }

    @Override
    public void updateDish(Long idDish, DishUpdateRequestDto dishUpdateRequestDto) {
        DishModel dishModel = dishRequestMapper.toDishModelUpdate(dishUpdateRequestDto);
        dishServicePort.updateDish(idDish,dishModel);
    }
}
