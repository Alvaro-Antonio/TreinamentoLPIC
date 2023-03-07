package com.usermanager.simulated.services.simulated;

import com.usermanager.simulated.AlternativeRepository;
import com.usermanager.simulated.QuestionRepository;
import com.usermanager.simulated.DTO.simulated.QuestionWithAlternativesDTO;
import com.usermanager.simulated.jpa.Alternative;
import com.usermanager.simulated.jpa.Question;
import com.usermanager.simulated.services.simulated.GetSimulatedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetSimulatedServiceImpl implements GetSimulatedService {

    private final AlternativeRepository alternativeRepository;
    private final QuestionRepository questionRepository;

    @Override
    public List<QuestionWithAlternativesDTO> getQuestionsWithAlternatives(int amount) {
        List<Question> questions = questionRepository.findAllRandonAndLimited(amount);
        List <Long> ids = questions.stream().map(Question::getId).toList();
        List<Alternative> alternatives = alternativeRepository.findAllByQuestionWithAlternatives(ids);

        List<QuestionWithAlternativesDTO> questionWithAlternatives = new ArrayList<>();

        for (Question question : questions){
            QuestionWithAlternativesDTO questionComplete = new QuestionWithAlternativesDTO();
            questionComplete.setQuestion(question);

            // TODO   aprimorar código
            for (Alternative alternative : alternatives){
                if (alternative.getQuestion().getId().equals(question.getId())){
                    questionComplete.getAlternatives().add(alternative);
                }
            }
            questionWithAlternatives.add(questionComplete);
        }

        return questionWithAlternatives;
    }
}
