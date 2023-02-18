package com.usermanager.simulated.services.question;

import com.usermanager.simulated.DTO.question.QuestionCreateDTO;
import com.usermanager.simulated.jpa.Question;

@FunctionalInterface
public interface CreateQuestionService {
    Question createQuestion(Long userId, QuestionCreateDTO questionCreateDTO);
}
