package com.winningwithwynny.quizzy.request;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizRequest {
    private String title;
    private String description;
    private List<String> tags;
}
