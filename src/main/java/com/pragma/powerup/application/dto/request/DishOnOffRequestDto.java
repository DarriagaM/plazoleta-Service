package com.pragma.powerup.application.dto.request;

import jdk.jfr.Name;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class DishOnOffRequestDto {
    @NotNull
    private Long id;
    @NotNull
    private boolean estado;
}
