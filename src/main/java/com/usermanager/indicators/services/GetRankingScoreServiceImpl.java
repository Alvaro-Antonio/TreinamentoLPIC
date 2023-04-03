package com.usermanager.indicators.services;

import com.usermanager.indicators.IndicatorsRepository;
import com.usermanager.indicators.jpa.Indicators;
import com.usermanager.users.User;
import com.usermanager.users.UserRepository;
import com.usermanager.users.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetRankingScoreServiceImpl implements GetRakingScoreService {

    private final IndicatorsRepository indicatorsRepository;


    @Override
    public List<Indicators> getRankingIndicators(Long userId) {
        indicatorsRepository.findAllByOrderByScoreDesc();

        return null;
    }
}
