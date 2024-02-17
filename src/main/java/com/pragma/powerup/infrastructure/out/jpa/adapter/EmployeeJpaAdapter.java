package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.EmployeeModel;
import com.pragma.powerup.domain.spi.IEmployeePersistencePort;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import com.pragma.powerup.infrastructure.out.jpa.entity.EmployeeEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IEmployeeEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IEmployeeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class EmployeeJpaAdapter implements IEmployeePersistencePort {
    private final IEmployeeEntityMapper employeeEntityMapper;
    private final IEmployeeRepository employeeRepository;
    @Override
    public EmployeeModel saveEmployee(EmployeeModel employeeModel) {
        EmployeeEntity employeeEntity = employeeRepository.save(employeeEntityMapper.toEmployeeEntity(employeeModel));
        return employeeEntityMapper.toEmployeeModel(employeeEntity);
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
        if(employeeEntityList.isEmpty()){
            throw  new NoDataFoundException();
        }
        return employeeEntityMapper.toEmployeeModelList(employeeEntityList);
    }

    @Override
    public EmployeeModel findByIdEmployee(String idEmployee) {
        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findByIdEmployee(idEmployee);
        EmployeeEntity employeeEntity = employeeEntityOptional.orElse(null);
        return employeeEntityMapper.toEmployeeModel(employeeEntity);
    }
}
