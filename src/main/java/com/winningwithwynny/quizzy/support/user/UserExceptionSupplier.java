package com.winningwithwynny.quizzy.support.user;

import com.winningwithwynny.quizzy.support.exception.user.EmailAlreadyExistException;
import com.winningwithwynny.quizzy.support.exception.user.UserNotFoundException;
import com.winningwithwynny.quizzy.support.exception.user.UsernameAlreadyExistException;

import java.util.function.Supplier;

public class UserExceptionSupplier {
    public static Supplier<UsernameAlreadyExistException> userAlreadyExist(String username){
        return () -> new UsernameAlreadyExistException(username);
    }
    public static Supplier<EmailAlreadyExistException> emailAlreadyExist(String email){
        return () -> new EmailAlreadyExistException(email);
    }

    public static Supplier<UserNotFoundException> userNotFound(Long id){
        return () -> new UserNotFoundException(id);
    }

}
