package com.winningwithwynny.quizzy.repository;

import com.winningwithwynny.quizzy.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    boolean existsByTitle(String title);
}
