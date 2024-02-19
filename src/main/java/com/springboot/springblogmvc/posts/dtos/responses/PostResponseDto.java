package com.springboot.springblogmvc.posts.dtos.responses;

import java.util.Date;

import lombok.Data;

@Data
public class PostResponseDto {
    private String title;
    private String category;
    private String author;
    private String excerpt;
    private String slug;
    private String body;
    private Date publishedAt;
    private Date createdAt;
    private Date updatedAt;
}
