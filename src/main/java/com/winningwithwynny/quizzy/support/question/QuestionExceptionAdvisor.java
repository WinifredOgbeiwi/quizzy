package com.winningwithwynny.quizzy.support.question;


import com.winningwithwynny.quizzy.support.ErrorMessageResponse;
import com.winningwithwynny.quizzy.support.exception.question.QuestionNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class QuestionExceptionAdvisor {


    @ExceptionHandler(QuestionNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageResponse quizNotFound(Exception e) {
        log.error("Error {}", e.getMessage(), e);
        return new ErrorMessageResponse("Error: " + e.getMessage());
    }
}
