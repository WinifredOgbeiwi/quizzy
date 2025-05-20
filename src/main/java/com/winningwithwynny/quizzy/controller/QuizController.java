package com.winningwithwynny.quizzy.controller;

import com.winningwithwynny.quizzy.request.QuizRequest;
import com.winningwithwynny.quizzy.response.QuizResponse;
import com.winningwithwynny.quizzy.service.QuizService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/quiz")
@AllArgsConstructor

public class QuizController {
    private final QuizService quizService;

    @PostMapping
    @Operation(summary = "Create Quiz")
    public ResponseEntity<QuizResponse> create(@RequestBody QuizRequest quizRequest){
        QuizResponse quizResponse = quizService.create(quizRequest);
        return  new ResponseEntity<>(quizResponse, HttpStatus.CREATED);
    }

}
