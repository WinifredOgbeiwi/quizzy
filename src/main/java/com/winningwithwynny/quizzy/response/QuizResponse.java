package com.winningwithwynny.quizzy.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizResponse {
    private Long id;
    private String title;
    private String description;
    private List<String> tags;
}
