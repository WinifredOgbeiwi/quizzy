package com.winningwithwynny.quizzy.service;

import com.winningwithwynny.quizzy.model.Question;
import com.winningwithwynny.quizzy.repository.QuestionRepository;
import com.winningwithwynny.quizzy.request.QuestionRequest;
import com.winningwithwynny.quizzy.response.QuestionResponse;
import com.winningwithwynny.quizzy.support.question.QuestionExceptionSupplier;
import com.winningwithwynny.quizzy.support.question.QuestionMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    private final QuestionMapper questionMapper;

    public QuestionResponse create(QuestionRequest questionRequest){
        Question question = questionRepository.save(questionMapper.toQuestion(questionRequest));
        return questionMapper.toQuestionResponse(question);
    }

    public QuestionResponse update(Long id, QuestionRequest questionRequest){
        Question question = questionRepository.findById(id).orElseThrow(QuestionExceptionSupplier.questionNotFound(id));
        questionRepository.save(questionMapper.toQuestion(questionRequest));
        return questionMapper.toQuestionResponse(question);
    }

    public List<QuestionResponse> findAll(){
        return questionRepository.findAll().stream().map(questionMapper::toQuestionResponse).collect(Collectors.toList());
    }

    public QuestionResponse find(Long id){
        Question question = questionRepository.findById(id).orElseThrow(QuestionExceptionSupplier.questionNotFound(id));
        return questionMapper.toQuestionResponse(question);
    }

    public QuestionResponse delete(Long id){
        Question question = questionRepository.findById(id).orElseThrow(QuestionExceptionSupplier.questionNotFound(id));
        questionRepository.deleteById(question.getId());
        return questionMapper.toQuestionResponse(question);
    }
}
