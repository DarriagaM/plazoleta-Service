package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.EmployeeRequestDto;
import com.pragma.powerup.application.dto.response.EmployeeResponseDto;
import com.pragma.powerup.application.handler.IEmployeeHandler;
import com.pragma.powerup.application.mapper.IEmployeeRequestMapper;
import com.pragma.powerup.application.mapper.IEmployeeResponseMapper;
import com.pragma.powerup.domain.api.IEmployeeServicePort;
import com.pragma.powerup.domain.model.EmployeeModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeHandler implements IEmployeeHandler {
    private final IEmployeeServicePort employeeServicePort;
    private final IEmployeeResponseMapper employeeResponseMapper;
    private final IEmployeeRequestMapper employeeRequestMapper;
    @Override
    public void saveEmployee(EmployeeRequestDto employeeRequestDto) {
        EmployeeModel employeeModel = employeeRequestMapper.toEmployeeModel(employeeRequestDto);
        employeeServicePort.saveEmployee(employeeModel);
    }

    @Override
    public List<EmployeeResponseDto> getAllEmployees() {
        return employeeResponseMapper.toEmployeeResponseDtoList(employeeServicePort.getAllEmployees());
    }
}
