package com.winningwithwynny.quizzy.support.exception.quiz;

import java.text.MessageFormat;

public class QuizNotFoundException extends RuntimeException{
    public QuizNotFoundException(Long id){
        super(MessageFormat.format("Quiz `{0}`  not found  exist",id));
    }
}
