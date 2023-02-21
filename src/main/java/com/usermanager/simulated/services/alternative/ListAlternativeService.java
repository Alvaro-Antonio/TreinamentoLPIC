package com.usermanager.simulated.services.alternative;

import com.usermanager.simulated.jpa.Alternative;

import java.util.List;

@FunctionalInterface
public interface ListAlternativeService {
    List<Alternative> listAlternative(Long userId, Long questionId);
}
