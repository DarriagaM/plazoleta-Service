package com.pragma.powerup.application.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class EmployeeRequestDto {

    @NotBlank()
    private String idRestaurant;
    @NotBlank()
    private String idEmployee;
}
