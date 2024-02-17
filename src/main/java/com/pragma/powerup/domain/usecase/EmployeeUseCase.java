package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IEmployeeServicePort;
import com.pragma.powerup.domain.model.EmployeeModel;
import com.pragma.powerup.domain.spi.IEmployeePersistencePort;

import java.util.List;

public class EmployeeUseCase implements IEmployeeServicePort {
    private final IEmployeePersistencePort employeePersistencePort;

    public EmployeeUseCase(IEmployeePersistencePort employeePersistencePort) {
        this.employeePersistencePort = employeePersistencePort;
    }

    @Override
    public void saveEmployee(EmployeeModel employeeModel) {
        employeePersistencePort.saveEmployee(employeeModel);
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        return employeePersistencePort.getAllEmployees();
    }
}
