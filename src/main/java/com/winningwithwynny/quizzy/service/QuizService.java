package com.winningwithwynny.quizzy.service;

import com.winningwithwynny.quizzy.model.Quiz;
import com.winningwithwynny.quizzy.repository.QuizRepository;
import com.winningwithwynny.quizzy.request.QuizRequest;
import com.winningwithwynny.quizzy.response.QuizResponse;
import com.winningwithwynny.quizzy.support.quiz.QuizMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;

    private final QuizMapper quizMapper;

    public QuizResponse create(QuizRequest quizRequest){
        Quiz quiz = quizRepository.save(quizMapper.toQuiz(quizRequest));
        return quizMapper.toQuizResponse(quiz);
    }

}
