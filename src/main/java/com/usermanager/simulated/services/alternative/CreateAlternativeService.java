package com.usermanager.simulated.services.alternative;

import com.usermanager.simulated.jpa.Alternative;

@FunctionalInterface
public interface CreateAlternativeService {
    Alternative createAlternative();
}
