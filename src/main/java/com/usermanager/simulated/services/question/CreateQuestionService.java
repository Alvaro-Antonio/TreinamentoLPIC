package com.usermanager.simulated.services.question;

import com.usermanager.simulated.jpa.Question;

@FunctionalInterface
public interface CreateQuestionService {
    Question createQuestion();
}
