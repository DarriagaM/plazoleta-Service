package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.DishOnOffRequestDto;
import com.pragma.powerup.application.dto.request.DishRequestDto;
import com.pragma.powerup.application.dto.request.DishUpdateRequestDto;
import com.pragma.powerup.application.dto.response.DishResponseDto;

import java.util.List;

public interface IDishHandler {
    void saveDish(DishRequestDto dishRequestDto);
    DishResponseDto getDishById(Long id);
    List<DishResponseDto> getDishResponseDtoList();
    void deleteDish(Long id);

    void SetOnOff(DishOnOffRequestDto dishOnOff);

    void updateDish(Long idDish, DishUpdateRequestDto dishUpdateRequestDto);
}
