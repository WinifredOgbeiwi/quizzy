package com.winningwithwynny.quizzy.support.question;

import com.winningwithwynny.quizzy.model.Question;
import com.winningwithwynny.quizzy.request.QuestionRequest;
import com.winningwithwynny.quizzy.response.QuestionResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionMapper {

    public Question toQuestion(QuestionRequest questionRequest){
        return new Question(questionRequest.getQuiz_id(),questionRequest.getQuestion(),questionRequest.getOptions(),questionRequest.getCorrectAnswer());
    }

    public QuestionResponse toQuestionResponse (Question question){
        return new QuestionResponse(
                question.getId(),
                question.getQuiz().getId(),
                question.getQuestion(),
                question.getOptions(),
                question.getCorrectAnswer()

        );

    }
}
