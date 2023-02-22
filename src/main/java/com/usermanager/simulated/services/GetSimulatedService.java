package com.usermanager.simulated.services;

import com.usermanager.simulated.QuestionWithAlternatives;

import java.util.List;

@FunctionalInterface
public interface GetSimulatedService {
    List<QuestionWithAlternatives> getQuestionsWithAlternatives(int amount);
}
