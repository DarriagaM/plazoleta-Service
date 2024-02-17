package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.RestaurantModel;
import com.pragma.powerup.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import com.pragma.powerup.infrastructure.out.jpa.entity.RestaurantEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IRestaurantEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IRestaurantRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RestaurantJpaAdapter implements IRestaurantPersistencePort {
    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;
    @Override
    public RestaurantModel saveRestaurantModel(RestaurantModel restaurantModel) {
        RestaurantEntity restaurantEntity = restaurantRepository.save(restaurantEntityMapper.toRestaurantEntity(restaurantModel));
        return restaurantEntityMapper.toRestaurantModel(restaurantEntity);
    }

    @Override
    public RestaurantModel getRequestRestaurantByIdOwner(Long idOwner) {
        Optional<RestaurantEntity> restaurantEntityOptional = restaurantRepository.getRequestRestaurantByIdPropietario(idOwner);
        RestaurantEntity restaurantEntity = restaurantEntityOptional.orElse(null);
        return restaurantEntityMapper.toRestaurantModel(restaurantEntity);
    }

    @Override
    public RestaurantModel getRestaurantModelById(Long id) {
        Optional<RestaurantEntity> optionalRestaurantEntity = restaurantRepository.findById(id);
        RestaurantEntity restaurantEntity = optionalRestaurantEntity.orElse(null);
        return restaurantEntityMapper.toRestaurantModel(restaurantEntity);
    }

    @Override
    public List<RestaurantModel> getRestaurantModelList() {
        List<RestaurantEntity> restaurantEntityList = restaurantRepository.findAll();
        if(restaurantEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return restaurantEntityMapper.toRestaurantModelList(restaurantEntityList);
    }

    @Override
    public void deleteRestaurantModelById(Long id) {
        restaurantRepository.deleteById(id);
    }
}
