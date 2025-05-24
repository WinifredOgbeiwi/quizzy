package com.winningwithwynny.quizzy.service;

import com.winningwithwynny.quizzy.model.Question;
import com.winningwithwynny.quizzy.model.Quiz;
import com.winningwithwynny.quizzy.repository.QuestionRepository;
import com.winningwithwynny.quizzy.repository.QuizRepository;
import com.winningwithwynny.quizzy.request.AnswerRequest;
import com.winningwithwynny.quizzy.request.QuizRequest;
import com.winningwithwynny.quizzy.response.QuizResponse;
import com.winningwithwynny.quizzy.response.QuizResultResponse;
import com.winningwithwynny.quizzy.support.quiz.QuizExceptionSupplier;
import com.winningwithwynny.quizzy.support.quiz.QuizMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;

    private final QuizMapper quizMapper;
    private final QuestionRepository questionRepository;

    public QuizResponse create(QuizRequest quizRequest){
        if(quizRepository.existsByTitle(quizRequest.getTitle())){
            throw QuizExceptionSupplier.quizAlreadyExist(quizRequest.getTitle()).get();
        }
        Quiz quiz = quizRepository.save(quizMapper.toQuiz(quizRequest));
        return quizMapper.toQuizResponse(quiz);
    }

    public QuizResponse update(Long id, QuizRequest quizRequest){
        Quiz quiz = quizRepository.findById(id).orElseThrow(QuizExceptionSupplier.quizNotFound(id));
        quizRepository.save(quizMapper.toQuiz(quizRequest));
        return quizMapper.toQuizResponse(quiz);
    }

    public List<QuizResponse> findAll(){
        return quizRepository.findAll().stream().map(quizMapper::toQuizResponse).collect(Collectors.toList());
    }

    public QuizResponse find(Long id){
        Quiz quiz = quizRepository.findById(id).orElseThrow(QuizExceptionSupplier.quizNotFound(id));
        return quizMapper.toQuizResponse(quiz);
    }

    public QuizResponse delete(Long id){
        Quiz quiz = quizRepository.findById(id).orElseThrow(QuizExceptionSupplier.quizNotFound(id));
        questionRepository.deleteByQuizId(id);
        quizRepository.deleteById(quiz.getId());
        return quizMapper.toQuizResponse(quiz);
    }


    public QuizResultResponse submitAnswers(Long quizId, AnswerRequest answerRequest) {
        List<Question> questions = questionRepository.findByQuizId(quizId);

        int total = questions.size();
        int correct = 0;

        for (Question question : questions) {
            String selectedAnswer = answerRequest.getAnswers().get(question.getId());
            if (selectedAnswer != null && selectedAnswer.equals(question.getAnswer())) {
                correct++;
            }
        }

        double percentage = (double) correct / total * 100;

        return new QuizResultResponse(total, correct, (int) percentage);
    }

}
