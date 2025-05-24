package com.winningwithwynny.quizzy.support.question;

import com.winningwithwynny.quizzy.model.Question;
import com.winningwithwynny.quizzy.request.QuestionRequest;
import com.winningwithwynny.quizzy.response.QuestionResponse;
import com.winningwithwynny.quizzy.response.UserQuestionResponse;
import org.springframework.stereotype.Component;

@Component
public class QuestionMapper {

    public Question toQuestion(QuestionRequest questionRequest){
        return new Question(questionRequest.getQuiz_id(),questionRequest.getQuestion(),questionRequest.getOptions(),questionRequest.getAnswer(),questionRequest.getExplanation());
    }

    public QuestionResponse toQuestionResponse (Question question){
        return new QuestionResponse(
                question.getId(),
                question.getQuiz().getId(),
                question.getQuestion(),
                question.getOptions(),
                question.getAnswer(),
                question.getExplanation()

        );

    }


    public UserQuestionResponse toQuizStartResponse (Question question){
        return new UserQuestionResponse(
                question.getId(),
                question.getQuestion(),
                question.getOptions()
        );

    }
}
