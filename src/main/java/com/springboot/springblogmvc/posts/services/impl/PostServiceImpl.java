package com.springboot.springblogmvc.posts.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.springblogmvc.posts.entities.Post;
import com.springboot.springblogmvc.posts.repositories.PostRepository;
import com.springboot.springblogmvc.posts.services.PostService;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    
}
