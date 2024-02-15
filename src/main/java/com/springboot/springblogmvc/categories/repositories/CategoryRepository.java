package com.springboot.springblogmvc.categories.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.springblogmvc.categories.entities.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    Category findOneBySlug(String slug);
}
