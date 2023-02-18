package com.usermanager.simulated.services.feedback;

import com.usermanager.simulated.FeedbackRepository;
import com.usermanager.simulated.jpa.Feedback;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateFeedbackServiceImpl implements CreateFeedbackService {
    private final FeedbackRepository feedbackRepository;

    public Feedback createFeedback(Feedback feedback){

        return feedbackRepository.save(feedback);
    }
}
