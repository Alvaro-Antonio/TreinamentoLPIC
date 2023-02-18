package com.usermanager.simulated.services.feedback;

import com.usermanager.simulated.jpa.Feedback;

@FunctionalInterface
public interface CreateFeedbackService {
    Feedback createFeedback(Feedback feedback);
}
