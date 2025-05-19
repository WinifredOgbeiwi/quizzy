package com.winningwithwynny.quizzy.support.exception.user;

import java.text.MessageFormat;

public class UsernameAlreadyExistException extends RuntimeException {
    public UsernameAlreadyExistException(String username){
        super(MessageFormat.format("Username `{0}`  already  exist",username));
    }
}
