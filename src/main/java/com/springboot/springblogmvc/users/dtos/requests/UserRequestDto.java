package com.springboot.springblogmvc.users.dtos.requests;

import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private String username;
    private String email;
    private String password;
}
