package com.winningwithwynny.quizzy.support.quiz;

import com.winningwithwynny.quizzy.support.exception.quiz.QuizAlreadyExistException;
import com.winningwithwynny.quizzy.support.exception.quiz.QuizNotFoundException;

import java.util.function.Supplier;

public class QuizExceptionSupplier {
        public static Supplier<QuizAlreadyExistException> quizAlreadyExist(String title){
            return () -> new QuizAlreadyExistException(title);
        }

    public static Supplier<QuizNotFoundException> quizNotFound(Long id){
        return () -> new QuizNotFoundException(id);
    }
}
