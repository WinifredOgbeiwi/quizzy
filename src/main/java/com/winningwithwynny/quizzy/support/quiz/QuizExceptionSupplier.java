package com.winningwithwynny.quizzy.support.quiz;

import com.winningwithwynny.quizzy.support.exception.quiz.QuizAlreadyExistException;
import com.winningwithwynny.quizzy.support.exception.user.EmailAlreadyExistException;
import com.winningwithwynny.quizzy.support.exception.user.UserNotFoundException;
import com.winningwithwynny.quizzy.support.exception.user.UsernameAlreadyExistException;

import java.util.function.Supplier;

public class QuizExceptionSupplier {
        public static Supplier<QuizAlreadyExistException> quizAlreadyExist(String title){
            return () -> new QuizAlreadyExistException(title);
        }
}
