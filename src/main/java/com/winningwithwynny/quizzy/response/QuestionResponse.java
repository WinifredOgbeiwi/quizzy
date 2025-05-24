package com.winningwithwynny.quizzy.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponse {
    private Long id;
    private Long quiz_id;
    private String question;
    private List<String> options;
    private String answer;
    private  String explanation;

}
