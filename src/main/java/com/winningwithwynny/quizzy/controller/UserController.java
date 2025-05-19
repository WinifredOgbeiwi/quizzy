package com.winningwithwynny.quizzy.controller;

import com.winningwithwynny.quizzy.request.UserRequest;
import com.winningwithwynny.quizzy.response.UserResponse;
import com.winningwithwynny.quizzy.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor

public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.create(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }
}