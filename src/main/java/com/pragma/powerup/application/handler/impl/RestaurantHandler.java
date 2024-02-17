package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.RestaurantRequestDto;
import com.pragma.powerup.application.dto.response.RestaurantResponseDto;
import com.pragma.powerup.application.handler.IRestaurantHandler;
import com.pragma.powerup.application.mapper.IRestaurantRequestMapper;
import com.pragma.powerup.application.mapper.IRestaurantResponseMapper;
import com.pragma.powerup.domain.api.IRestaurantServicePort;
import com.pragma.powerup.domain.model.RestaurantModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantHandler implements IRestaurantHandler {
    private final IRestaurantServicePort restaurantServicePort;
    private final IRestaurantRequestMapper restaurantRequestMapper;
    private final IRestaurantResponseMapper restaurantResponseMapper;

    @Override
    public void saveRestaurant(RestaurantRequestDto restaurantRequestDto) {
        restaurantServicePort.saveRestaurant(restaurantRequestMapper.toRestaurantModel(restaurantRequestDto));
    }

    @Override
    public RestaurantResponseDto getRequestRestaurantByIdOwner(Long idOwner) {
        RestaurantModel restaurantModel = restaurantServicePort.getRequestRestaurantByIdOwner(idOwner);
        return restaurantResponseMapper.toResponseRestaurantDto(restaurantModel);
    }

    @Override
    public RestaurantResponseDto getRequestRestaurantDtoById(Long id) {
        RestaurantModel restaurantModel = restaurantServicePort.getRestaurantModelById(id);
        return restaurantResponseMapper.toResponseRestaurantDto(restaurantModel);
    }

    @Override
    public List<RestaurantResponseDto> getRequestRestaurantDtoList() {
        List<RestaurantModel> restaurantModelList = restaurantServicePort.getAllRestaurantModelList();
        return restaurantResponseMapper.toResponseRestaurantDtoList(restaurantModelList);
    }

    @Override
    public void deleteRequestRestaurantById(Long id) {
        restaurantServicePort.deleteRestaurantById(id);
    }
}
