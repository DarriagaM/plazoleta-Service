package com.pragma.powerup.infrastructure.out.jpa.mapper;

import com.pragma.powerup.domain.model.EmployeeModel;
import com.pragma.powerup.infrastructure.out.jpa.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IEmployeeEntityMapper {
    EmployeeEntity toEmployeeEntity(EmployeeModel employeeModel);
    EmployeeModel toEmployeeModel(EmployeeEntity employeeEntity);
    List<EmployeeModel> toEmployeeModelList(List<EmployeeEntity> employeeEntityList);

}
