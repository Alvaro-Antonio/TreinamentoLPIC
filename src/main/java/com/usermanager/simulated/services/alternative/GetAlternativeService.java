package com.usermanager.simulated.services.alternative;

import com.usermanager.simulated.jpa.Alternative;

@FunctionalInterface
public interface GetAlternativeService {
    Alternative getAlternative(Long userId, Long questionId, Long id);
}
