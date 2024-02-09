package com.springboot.springblogmvc.dtos.requests;

import java.util.Date;
import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private String username;
    private String email;
    private String password;
}
