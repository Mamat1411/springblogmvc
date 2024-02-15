package com.springboot.springblogmvc.categories.entities;

import com.springboot.springblogmvc.posts.entities.Post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "categories")
public class Category {

    public Category(){

    }

    public Category(String name, String slug){
        this.name = name;
        this.slug = slug;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "slug", unique = true)
    private String slug;

    // @OneToOne(mappedBy = "categoryId")
    // private Post post;
}
