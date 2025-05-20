package com.winningwithwynny.quizzy.support.question;

import com.winningwithwynny.quizzy.support.exception.question.QuestionNotFoundException;
import com.winningwithwynny.quizzy.support.exception.quiz.QuizNotFoundException;

import java.util.function.Supplier;

public class QuestionExceptionSupplier {
    public static Supplier<QuestionNotFoundException> questionNotFound(Long id) {
        return () -> new QuestionNotFoundException(id);
    }
}