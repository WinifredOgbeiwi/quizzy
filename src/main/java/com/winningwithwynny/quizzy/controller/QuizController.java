package com.winningwithwynny.quizzy.controller;

import com.winningwithwynny.quizzy.request.AnswerRequest;
import com.winningwithwynny.quizzy.request.QuizRequest;
import com.winningwithwynny.quizzy.response.QuestionResponse;
import com.winningwithwynny.quizzy.response.QuizResponse;
import com.winningwithwynny.quizzy.response.QuizResultResponse;
import com.winningwithwynny.quizzy.service.QuestionService;
import com.winningwithwynny.quizzy.service.QuizService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/quiz")
@AllArgsConstructor

public class QuizController {
    private final QuizService quizService;
    private final QuestionService questionService;

    @PostMapping
    @Operation(summary = "Create Quiz")
    public ResponseEntity<QuizResponse> create(@RequestBody QuizRequest quizRequest){
        QuizResponse quizResponse = quizService.create(quizRequest);
        return  new ResponseEntity<>(quizResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Quiz")
    public ResponseEntity<QuizResponse> update(@PathVariable Long id, @RequestBody QuizRequest quizRequest) {
        QuizResponse quizResponse = quizService.update(id, quizRequest);
        return ResponseEntity.status(HttpStatus.OK).body(quizResponse);
    }

    @GetMapping("/")
    @Operation(summary = "Find All Quizzes")
    public ResponseEntity<List<QuizResponse>> findAll() {
        List<QuizResponse> quizResponse = quizService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(quizResponse);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find quiz by id")
    public ResponseEntity<QuizResponse> find(@PathVariable Long id) {
        QuizResponse quizResponse = quizService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(quizResponse);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete quiz")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        quizService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Quiz with ID: " + id + " has been deleted.");

    }

}
