package com.springboot.springblogmvc.posts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.springblogmvc.posts.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    Post findOneBySlug(String slug);
}
