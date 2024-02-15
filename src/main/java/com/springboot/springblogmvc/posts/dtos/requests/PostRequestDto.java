package com.springboot.springblogmvc.posts.dtos.requests;

import lombok.Data;

@Data
public class PostRequestDto {
    private String title;
    private String category;
    private String author;
    private String excerpt;
    private String slug;
    private String body;
}
