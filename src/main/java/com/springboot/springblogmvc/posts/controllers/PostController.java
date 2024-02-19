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

import com.springboot.springblogmvc.posts.dtos.requests.PostRequestDto;
import com.springboot.springblogmvc.posts.dtos.responses.PostResponseDto;
import com.springboot.springblogmvc.posts.entities.Post;
import com.springboot.springblogmvc.posts.services.PostService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





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
    
    @GetMapping("/{slug}")
    public ResponseEntity<?> getPostBySlug(@PathVariable("slug") String slug) {
        ModelMapper modelMapper = new ModelMapper();
        Map<String, Object> resultMap = new HashMap<>();
        try {
            Post post = postService.getPostBySlug(slug);
            PostResponseDto postResponseDto = modelMapper.map(post, PostResponseDto.class);
            resultMap.put("status", "200");
            resultMap.put("message", "success");
            resultMap.put("Data", postResponseDto);
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", "500");
            resultMap.put("message", "Internal Server Error");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/")
    public ResponseEntity<?> savePost(@RequestBody PostRequestDto postRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        Map<String, Object> resultMap = new HashMap<>();
        try {
            Post post = modelMapper.map(postRequestDto, Post.class);
            resultMap.put("status", "200");
            resultMap.put("message", "success");
            resultMap.put("Data", post);
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", "500");
            resultMap.put("message", "Internal Server Error");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/{slug}")
    public ResponseEntity<?> updatePost(@PathVariable String slug, @RequestBody PostRequestDto postRequestDto) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            Post post = postService.getPostBySlug(slug);
            post.setTitle(postRequestDto.getTitle());
            post.setCategoryId(Long.valueOf(postRequestDto.getCategory()));
            post.setExcerpt(postRequestDto.getExcerpt());
            post.setSlug(postRequestDto.getSlug());
            post.setBody(postRequestDto.getBody());
            postService.savePost(post);
            resultMap.put("status", "200");
            resultMap.put("message", "success");
            resultMap.put("Data", post);
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", "500");
            resultMap.put("message", "Internal Server Error");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{slug}")
    public ResponseEntity<?> deletePost(@PathVariable("slug") String slug){
        Map<String, Object> resultMap = new HashMap<>();
        try {
            Post post = postService.getPostBySlug(slug);
            postService.deletePost(post.getSlug());
            resultMap.put("status", "200");
            resultMap.put("message", "success");
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", "500");
            resultMap.put("message", "Internal Server Error");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
