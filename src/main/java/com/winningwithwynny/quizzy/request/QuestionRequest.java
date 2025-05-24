package com.winningwithwynny.quizzy.request;


import lombok.Data;

import java.util.List;

@Data
public class QuestionRequest {
    private Long quiz_id;
    private String question;
    private List<String> options;
    private String answer;
    private  String explanation;
}
