package com.winningwithwynny.quizzy.support.quiz;

import com.winningwithwynny.quizzy.model.Quiz;
import com.winningwithwynny.quizzy.request.QuizRequest;
import com.winningwithwynny.quizzy.response.QuizResponse;

public class QuizMapper {
    public Quiz toQuiz(QuizRequest quizRequest){
        return new Quiz( quizRequest.getTitle(), quizRequest.getDescription(),quizRequest.getTags());
    }

    public QuizResponse toQuizResponse (Quiz quiz){
        return new QuizResponse(quiz.getId(),quiz.getTitle(), quiz.getDescription(), quiz.getTags());
    }
}
