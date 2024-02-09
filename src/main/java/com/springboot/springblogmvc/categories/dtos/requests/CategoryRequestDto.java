package com.springboot.springblogmvc.categories.dtos.requests;

import lombok.Data;

@Data
public class CategoryRequestDto {
    private String name;
    private String slug;
}
