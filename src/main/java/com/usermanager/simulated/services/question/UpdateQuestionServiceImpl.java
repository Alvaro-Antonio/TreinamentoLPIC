package com.usermanager.simulated.services.question;

import com.usermanager.simulated.DTO.question.QuestionUpdateDTO;
import com.usermanager.simulated.QuestionRepository;
import com.usermanager.simulated.exceptions.QuestionNotfoundException;
import com.usermanager.simulated.jpa.Question;
import com.usermanager.users.User;
import com.usermanager.users.UserRepository;
import com.usermanager.users.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UpdateQuestionServiceImpl implements UpdateQuestionService {
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public Question updateQuestion(Long userId, Long questionId, QuestionUpdateDTO questionUpdateDto) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        Question question = questionRepository.findById(questionId).orElseThrow(QuestionNotfoundException::new);

        questionUpdate(question, questionUpdateDto);

        return questionRepository.save(question);
    }

    public void questionUpdate(Question question, QuestionUpdateDTO questionUpdateDto){
        question.setTitle(question.getTitle());
        question.setFeedback(questionUpdateDto.getFeedback());
    }
}
