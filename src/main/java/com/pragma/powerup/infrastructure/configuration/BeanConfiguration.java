package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.IDishServicePort;
import com.pragma.powerup.domain.api.IEmployeeServicePort;
import com.pragma.powerup.domain.api.IRestaurantServicePort;
import com.pragma.powerup.domain.spi.IDishPersistencePort;
import com.pragma.powerup.domain.spi.IEmployeePersistencePort;
import com.pragma.powerup.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.domain.spi.feignclient.IUserFeignPort;
import com.pragma.powerup.domain.spi.token.IToken;
import com.pragma.powerup.domain.usecase.DishUseCase;
import com.pragma.powerup.domain.usecase.EmployeeUseCase;
import com.pragma.powerup.domain.usecase.RestaurantUseCase;
import com.pragma.powerup.infrastructure.out.jpa.adapter.DishJpaAdapter;
import com.pragma.powerup.infrastructure.out.jpa.adapter.EmployeeJpaAdapter;
import com.pragma.powerup.infrastructure.out.jpa.adapter.RestaurantJpaAdapter;
import com.pragma.powerup.infrastructure.out.feingclient.IUserFeignClient;
import com.pragma.powerup.infrastructure.out.feingclient.adapter.UserFeignAdapter;
import com.pragma.powerup.infrastructure.out.feingclient.mapper.IUserFeignMapper;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IDishEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IEmployeeEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IRestaurantEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IDishRepository;
import com.pragma.powerup.infrastructure.out.jpa.repository.IEmployeeRepository;
import com.pragma.powerup.infrastructure.out.jpa.repository.IRestaurantRepository;
import com.pragma.powerup.infrastructure.out.token.TokenAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;

    private final IUserFeignClient userFeignClient;
    private final IUserFeignMapper userFeignMapper;

    private final IDishEntityMapper dishEntityMapper;
    private final IDishRepository dishRepository;

    private final IEmployeeEntityMapper employeeEntityMapper;
    private final IEmployeeRepository employeeRepository;


    @Bean
    public IEmployeePersistencePort employeePersistencePort(){
        return new EmployeeJpaAdapter(employeeEntityMapper,employeeRepository);
    }

    @Bean
    public IEmployeeServicePort employeeServicePort(){
        return new EmployeeUseCase(employeePersistencePort());
    }

    @Bean
    public IRestaurantPersistencePort restaurantPersistencePort() {
        return new RestaurantJpaAdapter(restaurantRepository, restaurantEntityMapper);
    }

    @Bean
    public IUserFeignPort userFeignPort(){
        return new UserFeignAdapter(userFeignClient,userFeignMapper);
    }

    @Bean
    public IRestaurantServicePort restaurantServicePort() {
        return new RestaurantUseCase(restaurantPersistencePort(),userFeignPort());
    }

    public IToken token(){
        return new TokenAdapter();
    }

    @Bean
    public IDishPersistencePort dishPersistencePort(){
        return new DishJpaAdapter(dishRepository,dishEntityMapper);
    }

    @Bean
    public IDishServicePort dishServicePort(){
        return new DishUseCase(dishPersistencePort(),restaurantPersistencePort(),token());
    }
}