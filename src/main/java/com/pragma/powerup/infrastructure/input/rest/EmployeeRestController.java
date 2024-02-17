package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.EmployeeRequestDto;
import com.pragma.powerup.application.dto.response.EmployeeResponseDto;
import com.pragma.powerup.application.handler.IEmployeeHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeRestController {
    private final IEmployeeHandler employeeHandler;


    @Operation(summary = "Add a new employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Employee already exists", content = @Content)
    })
    @PostMapping("/")
    @PreAuthorize("hasAuthority('PROPIETARIO')")
    public ResponseEntity<Void> saveRestaurantEmployee(@Valid @RequestBody EmployeeRequestDto employeeRequestDto) {
        employeeHandler.saveEmployee(employeeRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All employees returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = EmployeeResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    @PreAuthorize("hasAuthority('PROPIETARIO')")
    public ResponseEntity<List<EmployeeResponseDto>> getAllRestaurantEmployees() {
        return ResponseEntity.ok(employeeHandler.getAllEmployees());
    }


}
