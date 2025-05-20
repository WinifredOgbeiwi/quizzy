package com.winningwithwynny.quizzy.support.exception.quiz;

import java.text.MessageFormat;

public class QuizAlreadyExistException extends RuntimeException {

    public QuizAlreadyExistException(String title) {
        super(MessageFormat.format("Quiz Title `{0}`  already  exist", title));
    }
}