package com.usermanager.simulated.services.question;

@FunctionalInterface
public interface DeleteQuestionService {
    void deleteQuestion(Long userId, Long questionId);
}
