package com.usermanager.simulated.services.simulated;

import com.usermanager.simulated.DTO.simulated.QuestionWithAlternativesDTO;

import java.util.List;

@FunctionalInterface
public interface GetSimulatedService {
    List<QuestionWithAlternativesDTO> getQuestionsWithAlternatives(int amount);
}
