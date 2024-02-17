package com.pragma.powerup.infrastructure.out.jpa.repository;

import com.pragma.powerup.infrastructure.out.jpa.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IEmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    Optional<EmployeeEntity> findByIdEmployee(String idEmployee);
}
