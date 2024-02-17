package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.RestaurantRequestDto;
import com.pragma.powerup.application.dto.response.RestaurantResponseDto;
import com.pragma.powerup.application.handler.IRestaurantHandler;
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
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantRestController {

    private final IRestaurantHandler restaurantHandler;

    @Operation(summary = "Add a new restaurant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Restaurant created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Restaurant already exists", content = @Content)
    })
    @PostMapping("/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> saveRestaurant(@RequestBody RestaurantRequestDto restaurantRequestDto) {
        restaurantHandler.saveRestaurant(restaurantRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all restaurants")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All restaurants returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RestaurantResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<RestaurantResponseDto>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantHandler.getRequestRestaurantDtoList());
    }

    @Operation(summary = "Get restaurant by Id_Owner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Restaurant returnet", content = @Content),
            @ApiResponse(responseCode = "404", description = "Restaurant not found", content = @Content)
    })
    @GetMapping("/restaurantByIdOwner/{idOwner}")
    public ResponseEntity<RestaurantResponseDto> getRestaurantByIdOwner(@PathVariable(value = "idOwner") Long idOwner) {
        return ResponseEntity.ok(restaurantHandler.getRequestRestaurantByIdOwner(idOwner));
    }

}