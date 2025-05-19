package com.winningwithwynny.quizzy.support.exception.user;

import java.text.MessageFormat;

public class EmailAlreadyExistException extends  RuntimeException{
    public EmailAlreadyExistException(String email){
        super(MessageFormat.format("Email `{0}`  already  exist",email));
    }
}
