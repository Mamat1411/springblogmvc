package com.springboot.springblogmvc.posts.controllers;

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

import com.springboot.springblogmvc.posts.dtos.responses.PostResponseDto;
import com.springboot.springblogmvc.posts.entities.Post;
import com.springboot.springblogmvc.posts.services.PostService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/posts")
public class PostController {
    
    @Autowired
    PostService postService;

    @GetMapping("/")
    public ResponseEntity<?> getAllPosts() {
        ModelMapper modelMapper = new ModelMapper();
        Map<String, Object> resultMap = new HashMap<>();
        try {
            List<Post> posts = postService.getAllPosts();
            List<PostResponseDto> postResponseDtos = posts.stream().map(post -> modelMapper.map(post, PostResponseDto.class)).collect(Collectors.toList());
            resultMap.put("status", "200");
            resultMap.put("message", "success");
            resultMap.put("Data", postResponseDtos);
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", "500");
            resultMap.put("message", "Internal Server Error");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
