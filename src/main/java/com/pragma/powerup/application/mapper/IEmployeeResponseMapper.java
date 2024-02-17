package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.response.EmployeeResponseDto;
import com.pragma.powerup.domain.model.EmployeeModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IEmployeeResponseMapper {
    EmployeeModel toEmployeeModel(EmployeeResponseDto employeeResponseDto);
    EmployeeResponseDto toEmployeeResponseDto(EmployeeModel employeeModel);
    List<EmployeeResponseDto> toEmployeeResponseDtoList(List<EmployeeModel> employeeModelList);
}
