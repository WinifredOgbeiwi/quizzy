package com.winningwithwynny.quizzy.support.user;

import com.winningwithwynny.quizzy.support.ErrorMessageResponse;
import com.winningwithwynny.quizzy.support.exception.user.EmailAlreadyExistException;
import com.winningwithwynny.quizzy.support.exception.user.UserNotFoundException;
import com.winningwithwynny.quizzy.support.exception.user.UsernameAlreadyExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserExceptionAdvisor {


    private static final Logger LOG = LoggerFactory.getLogger(UserExceptionAdvisor.class);

    @ExceptionHandler(UsernameAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageResponse usernameAlreadyExit(Exception e) {
        LOG.error("User already exist: {}", e.getMessage(), e);
        return new ErrorMessageResponse("Error: " + e.getMessage());
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageResponse emailAlreadyExit(Exception e) {
        LOG.error("Email already exist: {}", e.getMessage(), e);
        return new ErrorMessageResponse("Error: " + e.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageResponse userNotFound(Exception e) {
        LOG.error("Error {}", e.getMessage(), e);
        return new ErrorMessageResponse("Error: " + e.getMessage());
    }

}
