package com.springboot.springblogmvc.categories.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.springblogmvc.categories.entities.Category;
import com.springboot.springblogmvc.categories.repositories.CategoryRepository;
import com.springboot.springblogmvc.categories.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    
}
