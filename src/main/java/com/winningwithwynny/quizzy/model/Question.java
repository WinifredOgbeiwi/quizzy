package com.winningwithwynny.quizzy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity(name = "question")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;

    @ElementCollection
    @Column(nullable = false)
    private List<String> options;

    @Column(nullable = false)
    private String correctAnswer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    public Question(Long quizId, String question, List<String> options, String correctAnswer) {
        this.quiz = new Quiz();
        this.quiz.setId(quizId);
    this.question = question;
    this.options = options;
    this.correctAnswer = correctAnswer;
    }
}
