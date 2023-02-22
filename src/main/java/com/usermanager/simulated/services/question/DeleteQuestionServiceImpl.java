package com.usermanager.simulated.services.question;

import com.usermanager.simulated.QuestionRepository;
import com.usermanager.users.User;
import com.usermanager.users.UserRepository;
import com.usermanager.users.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DeleteQuestionServiceImpl implements DeleteQuestionService {
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    @Override
    public void deleteQuestion(Long userId, Long questionId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);

        questionRepository.deleteById(questionId);
    }
}
