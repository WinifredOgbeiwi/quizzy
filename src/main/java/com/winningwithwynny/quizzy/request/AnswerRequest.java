package com.winningwithwynny.quizzy.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerRequest {
    private Long questionId;
    private String selectedOption;
}
