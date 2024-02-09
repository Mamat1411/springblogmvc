package com.springboot.springblogmvc.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springblogmvc.dtos.requests.UserRequestDto;
import com.springboot.springblogmvc.dtos.responses.UserResponseDto;
import com.springboot.springblogmvc.entities.User;
import com.springboot.springblogmvc.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers() {
        ModelMapper modelMapper = new ModelMapper();
        Map<String, Object> resultMap = new HashMap<>();
        try {
            List<User> users = userService.getAllUser();
            List<UserResponseDto> userResponseDtos = users.stream().map(user -> modelMapper.map(user, UserResponseDto.class)).collect(Collectors.toList());
            resultMap.put("status", "200");
            resultMap.put("message", "success");
            resultMap.put("Data", userResponseDtos);
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", "500");
            resultMap.put("message", "Internal Server Error");
            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{name}")
    public ResponseEntity<?> getUserByName(@PathVariable("name") String name) {
        ModelMapper modelMapper = new ModelMapper();
        Map<String, Object> resultMap = new HashMap<>();
        try {
            User user = userService.getUserByName(name);
            UserResponseDto userResponseDto = modelMapper.map(user, UserResponseDto.class);
            resultMap.put("status", "200");
            resultMap.put("message", "success");
            resultMap.put("Data", userResponseDto);
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", "500");
            resultMap.put("message", "Internal Server Error");
            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/")
    public ResponseEntity<?> saveUser(@RequestBody UserRequestDto userRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        Map<String, Object> resultMap = new HashMap<>();
        try {
            User user = modelMapper.map(userRequestDto, User.class);
            userService.saveUser(user);
            resultMap.put("status", "200");
            resultMap.put("message", "success");
            resultMap.put("Data", user);
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", "500");
            resultMap.put("message", "Internal Server Error");
            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/{name}")
    public ResponseEntity<?> updateUser(@PathVariable("name") String name, @RequestBody UserRequestDto userRequestDto) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            User user = userService.getUserByName(name);
            user.setName(userRequestDto.getName());
            user.setUsername(userRequestDto.getUsername());
            user.setEmail(userRequestDto.getEmail());
            user.setPassword(userRequestDto.getPassword());
            userService.saveUser(user);
            resultMap.put("status", "200");
            resultMap.put("message", "success");
            resultMap.put("Data", user);
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", "500");
            resultMap.put("message", "Internal Server Error");
            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteUser(@PathVariable("name") String name){
        Map<String, Object> resultMap = new HashMap<>();
        try {
            User user = userService.getUserByName(name);
            userService.deleteUser(user.getName());
            resultMap.put("Status", "200");
            resultMap.put("Message", "success");
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", "500");
            resultMap.put("message", "Internal Server Error");
            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
