package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.RestaurantRequestDto;
import com.pragma.powerup.application.dto.response.RestaurantResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

public interface IRestaurantHandler {
    void saveRestaurant(RestaurantRequestDto restaurantRequestDto);
    RestaurantResponseDto getRequestRestaurantByIdOwner(Long idOwner);
    RestaurantResponseDto getRequestRestaurantDtoById(Long id);
    List<RestaurantResponseDto> getRequestRestaurantDtoList();
    void deleteRequestRestaurantById(Long id);
}
