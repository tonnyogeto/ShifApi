package com.splash.shifapi.users.controller;

import com.splash.shifapi.infrastructure.Response.ApiResponse;
import com.splash.shifapi.users.dto.UserCreationDto;
import com.splash.shifapi.users.dto.UserFetchDto;
import com.splash.shifapi.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        List<UserFetchDto>users =userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("success",users));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?>getUserById(
            @PathVariable("userId") Integer userId
    ){
        UserFetchDto dto =userService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("success",dto)
        );
    }

    @PostMapping
    public ResponseEntity<?> createUser(
            @RequestBody UserCreationDto dto
            ){
        userService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ApiResponse<>("success",null));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(
            @PathVariable("userId") Integer userId,
            @RequestBody UserCreationDto dto
    ){
        userService.updateUser(dto, userId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("success", null));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(
            @PathVariable("userId") Integer userId
    ){
        userService.deleteUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("success",null));


    }
}
