package com.winningwithwynny.quizzy.repository;

import com.winningwithwynny.quizzy.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
