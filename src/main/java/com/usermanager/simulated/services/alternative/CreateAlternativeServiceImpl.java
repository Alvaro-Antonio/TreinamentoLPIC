package com.usermanager.simulated.services.alternative;

import com.usermanager.simulated.AlternativeRepository;
import com.usermanager.simulated.DTO.alternative.AlternativeCreateDTO;
import com.usermanager.simulated.QuestionRepository;
import com.usermanager.simulated.exceptions.QuestionNotfoundException;
import com.usermanager.simulated.jpa.Alternative;
import com.usermanager.simulated.jpa.Question;
import com.usermanager.users.User;
import com.usermanager.users.UserRepository;
import com.usermanager.users.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAlternativeServiceImpl implements CreateAlternativeService {

    private final AlternativeRepository alternativeRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public Alternative createAlternative(Long userId, Long questionId, AlternativeCreateDTO alternative){
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        Question question = questionRepository.findById(questionId).orElseThrow(QuestionNotfoundException::new);

        alternative.setQuestion(question);
        return alternativeRepository.save(Alternative.from(alternative));
    }
}
