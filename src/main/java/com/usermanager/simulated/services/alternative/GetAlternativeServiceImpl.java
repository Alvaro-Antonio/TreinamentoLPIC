package com.usermanager.simulated.services.alternative;

import com.usermanager.simulated.AlternativeRepository;
import com.usermanager.simulated.exceptions.AlternativeNotFoundException;
import com.usermanager.simulated.jpa.Alternative;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAlternativeServiceImpl implements GetAlternativeService {

    private final AlternativeRepository alternativeRepository;

    public Alternative getAlternative(Long userId, Long questionId, Long alternativeId){
        return alternativeRepository.findAlternativeByIdAndQuestionIdAndQuestionUserCreateId(alternativeId, questionId, userId)
                .orElseThrow(AlternativeNotFoundException::new);
    }
}
