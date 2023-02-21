package com.usermanager.simulated.services.alternative;

import com.usermanager.simulated.AlternativeRepository;
import com.usermanager.simulated.jpa.Alternative;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListAlternativeServiceImpl implements ListAlternativeService {

    private final AlternativeRepository alternativeRepository;

    public List<Alternative> listAlternative(Long userId, Long questionId){
        return alternativeRepository.findAllByQuestionIdAndQuestionUserCreateId(questionId, userId);
    }
}
