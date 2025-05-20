package com.winningwithwynny.quizzy.support.exception.question;

import java.text.MessageFormat;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException(Long id){
        super(MessageFormat.format("Question `{0}`  not found  exist",id));
    }
}
