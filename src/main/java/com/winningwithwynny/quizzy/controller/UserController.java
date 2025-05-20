package com.winningwithwynny.quizzy.controller;

import com.winningwithwynny.quizzy.request.UserRequest;
import com.winningwithwynny.quizzy.response.UserResponse;
import com.winningwithwynny.quizzy.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor

public class UserController {
    private final UserService userService;

    @PostMapping
    @Operation(summary = "Create User")
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.create(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @GetMapping("/")
    @Operation(summary = "Find All Users")
    public ResponseEntity<List<UserResponse>> findAll() {
        List<UserResponse> userResponses = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(userResponses);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find user by id")
    public ResponseEntity<UserResponse> find(@PathVariable Long id) {
        UserResponse userResponses = userService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponses);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user")
    public ResponseEntity<UserResponse> update(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.update(id, userRequest);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete item")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("User with ID " + id + " has been deleted.");

    }
}