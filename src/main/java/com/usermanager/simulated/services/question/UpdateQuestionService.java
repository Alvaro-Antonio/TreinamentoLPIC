package com.usermanager.simulated.services.question;

import com.usermanager.simulated.DTO.question.QuestionUpdateDTO;
import com.usermanager.simulated.jpa.Question;

@FunctionalInterface
public interface UpdateQuestionService {
    Question updateQuestion(Long userId, Long questionId, QuestionUpdateDTO questionUpdateDto);
}
