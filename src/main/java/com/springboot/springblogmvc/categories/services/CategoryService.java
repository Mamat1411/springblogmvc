package com.springboot.springblogmvc.categories.services;

import java.util.List;

import com.springboot.springblogmvc.categories.entities.Category;

public interface CategoryService {
    List<Category> getAllCategories();
}
