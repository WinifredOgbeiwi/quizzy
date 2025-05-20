package com.winningwithwynny.quizzy.support.exception.user;

import java.text.MessageFormat;

public class UserNotFoundException extends  RuntimeException {
    public UserNotFoundException(Long id){
        super(MessageFormat.format("User `{0}`  not found  exist",id));
    }
}

