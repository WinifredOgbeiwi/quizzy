package com.winningwithwynny.quizzy.controller;

import com.winningwithwynny.quizzy.request.QuestionRequest;
import com.winningwithwynny.quizzy.response.QuestionResponse;
import com.winningwithwynny.quizzy.service.QuestionService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/quiz/{quizId}/questions")
@AllArgsConstructor

public class QuestionController { 
    private  final QuestionService questionService;

    @PostMapping
    @Operation(summary = "Create Question")
    public ResponseEntity<QuestionResponse> create(@RequestBody QuestionRequest questionRequest){
        QuestionResponse questionResponse = questionService.create(questionRequest);
        return  new ResponseEntity<>(questionResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Question")
    public ResponseEntity<QuestionResponse> update(@PathVariable Long id, @RequestBody QuestionRequest questionRequest) {
        QuestionResponse questionResponse = questionService.update(id, questionRequest);
        return ResponseEntity.status(HttpStatus.OK).body(questionResponse);
    }

    @GetMapping("/")
    @Operation(summary = "Find All Question")
    public ResponseEntity<List<QuestionResponse>> findAll() {
        List<QuestionResponse> questionResponse = questionService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(questionResponse);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find Question by id")
    public ResponseEntity<QuestionResponse> find(@PathVariable Long id) {
        QuestionResponse questionResponse = questionService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(questionResponse);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Question")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        questionService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Question with ID: " + id + " has been deleted.");

    }
}
