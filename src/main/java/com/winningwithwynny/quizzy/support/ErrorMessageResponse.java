package com.winningwithwynny.quizzy.support;

public class ErrorMessageResponse {
    private  final String message;
    public ErrorMessageResponse(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
