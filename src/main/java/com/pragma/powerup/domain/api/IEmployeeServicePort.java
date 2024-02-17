package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.EmployeeModel;

import java.util.List;

public interface IEmployeeServicePort {
    void saveEmployee(EmployeeModel employeeModel);
    List<EmployeeModel> getAllEmployees();
}
