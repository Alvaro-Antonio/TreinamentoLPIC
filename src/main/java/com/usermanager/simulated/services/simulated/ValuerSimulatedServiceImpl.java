package com.usermanager.simulated.services.simulated;

import com.usermanager.indicators.IndicatorsRepository;
import com.usermanager.indicators.jpa.Indicators;
import com.usermanager.simulated.DTO.simulated.AnswerDTO;
import com.usermanager.simulated.DTO.simulated.SimulatedAnswersDTO;
import com.usermanager.users.User;
import com.usermanager.users.UserRepository;
import com.usermanager.users.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ValuerSimulatedServiceImpl implements ValuerSimulatedService{

    private final IndicatorsRepository indicatorsRepository;
    private final UserRepository userRepository;

    //Responsável por receber as respostas e verificar se estão corretas
    @Override
    public SimulatedAnswersDTO simulatedAnswers(Long userId, List<AnswerDTO> answers) {
        User user = this.userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        Indicators indicators = this.indicatorsRepository.findByUserId(userId);

        long score = 0;

        List<Long> ids = new ArrayList<>();
        SimulatedAnswersDTO simulatedAnswersDTO = new SimulatedAnswersDTO();
        simulatedAnswersDTO.setAnswers(answers);
        for (AnswerDTO answerDTO : answers){
            ids.add(answerDTO.getQuestion().getId());

            if (answerDTO.getAlternativeSelected().getCorrect()){
                score+=10;
            }
        }
        indicators.setScore(indicators.getScore() + score);
        indicatorsRepository.save(indicators);
        simulatedAnswersDTO.setScore(score);

        return simulatedAnswersDTO;
    }



}
