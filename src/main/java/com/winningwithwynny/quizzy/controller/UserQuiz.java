package com.winningwithwynny.quizzy.controller;

import com.winningwithwynny.quizzy.request.AnswerRequest;
import com.winningwithwynny.quizzy.response.QuizResultResponse;
import com.winningwithwynny.quizzy.response.UserQuestionResponse;
import com.winningwithwynny.quizzy.service.QuestionService;
import com.winningwithwynny.quizzy.service.QuizService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/quiz/{id}")
@AllArgsConstructor

public class UserQuiz {
    private final QuizService quizService;
    private final QuestionService questionService;


    @GetMapping("/start")
    @Operation(summary = "Start quiz and get questions")
    public ResponseEntity<List<UserQuestionResponse>> startQuiz( @PathVariable Long id) {
        List<UserQuestionResponse> questions = questionService.findByQuizId(id);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }


    @PostMapping("/submit")
    @Operation(summary = "Submit quiz and get score")
    public ResponseEntity<QuizResultResponse> submitQuiz(
            @PathVariable Long id,
            @RequestBody AnswerRequest answerRequest) {
        QuizResultResponse result = quizService.submitAnswers(id, answerRequest);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
