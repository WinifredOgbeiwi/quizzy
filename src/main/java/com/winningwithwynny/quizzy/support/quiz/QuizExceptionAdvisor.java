package com.winningwithwynny.quizzy.support.quiz;

import com.winningwithwynny.quizzy.support.ErrorMessageResponse;
import com.winningwithwynny.quizzy.support.exception.quiz.QuizAlreadyExistException;
import com.winningwithwynny.quizzy.support.exception.quiz.QuizNotFoundException;
import com.winningwithwynny.quizzy.support.exception.user.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class QuizExceptionAdvisor {

    @ExceptionHandler(QuizAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageResponse QuizAlreadyExit(Exception e) {
        log.error("Error Message: {}", e.getMessage(), e);
        return new ErrorMessageResponse("Error: " + e.getMessage());
    }

    @ExceptionHandler(QuizNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageResponse quizNotFound(Exception e) {
        log.error("Error {}", e.getMessage(), e);
        return new ErrorMessageResponse("Error: " + e.getMessage());
    }
}
