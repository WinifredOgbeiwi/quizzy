package com.winningwithwynny.quizzy.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizResultResponse {
    private int totalQuestions;
    private int answers;
    private int scorePercentage;
}