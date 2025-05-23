package com.winningwithwynny.quizzy.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQuestionResponse {
    private Long id;
    private String question;
    private List<String> options;

}
