package com.usermanager.simulated.services.simulated;

import com.usermanager.simulated.DTO.simulated.AnswerDTO;
import com.usermanager.simulated.DTO.simulated.SimulatedAnswersDTO;

import java.util.ArrayList;
import java.util.List;


public class ValuerSimulatedServiceImpl implements ValuerSimulatedService{

    //Responsável por receber as respostas e verificar se estão corretas
    @Override
    public SimulatedAnswersDTO simulatedAnswers(List<AnswerDTO> answers) {

        List<Long> ids = new ArrayList<>();
        for (AnswerDTO answerDTO : answers){
            ids.add(answerDTO.getQuestion().getId());
        }




        return null;
    }



}
