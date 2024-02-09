package com.springboot.springblogmvc.users.dtos.responses;

import java.util.Date;

import lombok.Data;

@Data
public class UserResponseDto {
    private String name;
    private String username;
    private String email;
    private Date createdDate;
    private Date updatedDate;
}
