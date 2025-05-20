package com.winningwithwynny.quizzy.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class QuestionRequest {
    private Long quiz_id;
    private String question;
    private List<String> options;
    private String correctAnswer;
}
