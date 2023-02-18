package com.usermanager.simulated.services.alternative;

import com.usermanager.simulated.AlternativeRepository;
import com.usermanager.simulated.QuestionRepository;
import com.usermanager.simulated.exceptions.QuestionNotfoundException;
import com.usermanager.simulated.jpa.Alternative;
import com.usermanager.simulated.jpa.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAlternativeServiceImpl implements CreateAlternativeService {

    private final AlternativeRepository alternativeRepository;
    private final QuestionRepository questionRepository;

    public Alternative createAlternative(Long questionId, Alternative alternative){
        Question question = questionRepository.findById(questionId).orElseThrow(QuestionNotfoundException::new);
        return alternativeRepository.save(alternative);
    }
}
