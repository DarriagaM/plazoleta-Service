package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.CategoryRequestDto;
import com.pragma.powerup.application.dto.response.CategoryResponseDto;
import com.pragma.powerup.application.handler.ICategoryHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryRestController {
    private final ICategoryHandler categoryHandler;

    @Operation(summary = "Add new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Category Created",content = @Content),
            @ApiResponse(responseCode = "409",description = "Category already exists",content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> saveCategory(@RequestBody CategoryRequestDto categoryRequestDto){
        categoryHandler.saveCategory(categoryRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All categories returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CategoryResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories(){
        return ResponseEntity.ok(categoryHandler.getAllCategory());
    }

    @Operation(summary = "Get category by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Category returned",content = @Content),
            @ApiResponse(responseCode = "404",description = "Category not found",content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable(value = "id")Long id){
        return ResponseEntity.ok(categoryHandler.getCategoryById(id));
    }

    @Operation(summary = "Delete category by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Category delete",content = @Content),
            @ApiResponse(responseCode = "404",description = "Category not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable(value = "id")Long id){
        categoryHandler.deleteCategoryById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
