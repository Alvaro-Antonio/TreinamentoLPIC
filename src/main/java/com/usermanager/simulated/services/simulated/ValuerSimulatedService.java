package com.usermanager.simulated.services.simulated;

import com.usermanager.simulated.DTO.simulated.AnswerDTO;
import com.usermanager.simulated.DTO.simulated.SimulatedAnswersDTO;

import java.util.List;

@FunctionalInterface
public interface ValuerSimulatedService {
    SimulatedAnswersDTO simulatedAnswers(List<AnswerDTO> answers);
}
