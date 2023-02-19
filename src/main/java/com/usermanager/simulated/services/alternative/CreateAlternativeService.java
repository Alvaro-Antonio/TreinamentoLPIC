package com.usermanager.simulated.services.alternative;

import com.usermanager.simulated.DTO.alternative.AlternativeCreateDTO;
import com.usermanager.simulated.jpa.Alternative;

@FunctionalInterface
public interface CreateAlternativeService {
    Alternative createAlternative(Long userId, Long questionId, AlternativeCreateDTO alternative);
}
