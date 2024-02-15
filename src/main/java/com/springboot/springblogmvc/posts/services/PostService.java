package com.springboot.springblogmvc.posts.services;

import java.util.List;

import com.springboot.springblogmvc.posts.entities.Post;

public interface PostService {
    List<Post> getAllPosts();
}
