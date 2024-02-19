package com.springboot.springblogmvc.posts.services;

import java.util.List;

import com.springboot.springblogmvc.posts.entities.Post;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostBySlug(String slug);
    Post savePost(Post post);
    void deletePost(String slug);
}
