package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.EmployeeModel;

import java.util.List;

public interface IEmployeePersistencePort {
    EmployeeModel saveEmployee(EmployeeModel employeeModel);
    List<EmployeeModel> getAllEmployees();

    EmployeeModel findByIdEmployee(String idEmployee);
}
