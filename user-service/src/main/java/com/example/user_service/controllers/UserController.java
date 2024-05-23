package com.example.user_service.controllers;

import com.example.user_service.model.dtos.UserRequest;
import com.example.user_service.model.dtos.UserResponse;
import com.example.user_service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void  addUser(@RequestBody UserRequest userRequest){
        this.userService.addUser(userRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @PutMapping("/{userId}")
    public void updateUser(@PathVariable Long userId, @RequestBody UserRequest userRequest) {
        userRequest.setId(userId);
        this.userService.updateUser(userRequest);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        this.userService.deleteUser(userId);
    }
}
