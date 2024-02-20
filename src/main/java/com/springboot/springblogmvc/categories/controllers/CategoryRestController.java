package com.springboot.springblogmvc.categories.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springblogmvc.categories.dtos.responses.CategoryResponseDto;
import com.springboot.springblogmvc.categories.entities.Category;
import com.springboot.springblogmvc.categories.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {
    
    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<?> getAllCategory() {
        ModelMapper modelMapper = new ModelMapper();
        Map<String, Object> resultMap = new HashMap<>();
        try {
            List<Category> categories = categoryService.getAllCategories();
            List<CategoryResponseDto> categoryResponseDtos = categories.stream().map(category -> modelMapper.map(category, CategoryResponseDto.class)).collect(Collectors.toList());
            resultMap.put("status", "200");
            resultMap.put("message", "success");
            resultMap.put("Data", categoryResponseDtos);
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", "500");
            resultMap.put("message", "Internal Server Error");
            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
