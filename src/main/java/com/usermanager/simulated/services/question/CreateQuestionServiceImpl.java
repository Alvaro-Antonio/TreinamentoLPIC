package com.usermanager.simulated.services.question;

import com.usermanager.simulated.DTO.question.QuestionCreateDTO;
import com.usermanager.simulated.FeedbackRepository;
import com.usermanager.simulated.QuestionRepository;
import com.usermanager.simulated.jpa.Feedback;
import com.usermanager.simulated.jpa.Question;
import com.usermanager.users.User;
import com.usermanager.users.UserRepository;
import com.usermanager.users.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CreateQuestionServiceImpl implements CreateQuestionService {
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    private final FeedbackRepository feedbackRepository;

    public Question createQuestion(Long userId, QuestionCreateDTO questionCreateDTO){
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        Feedback feedback = feedbackRepository.save(questionCreateDTO.getFeedback());

        questionCreateDTO.setUserCreate(user);
        questionCreateDTO.setFeedback(feedback);

        return questionRepository.save(Question.from(questionCreateDTO));
    }
}
