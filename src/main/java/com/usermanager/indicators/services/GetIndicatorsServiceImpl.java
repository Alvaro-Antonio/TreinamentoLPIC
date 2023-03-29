package com.usermanager.indicators.services;

import com.usermanager.indicators.IndicatorsRepository;
import com.usermanager.indicators.jpa.Indicators;
import com.usermanager.users.User;
import com.usermanager.users.UserRepository;
import com.usermanager.users.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetIndicatorsServiceImpl implements GetIndicatorsService {

    private final UserRepository userRepository;
    private final IndicatorsRepository indicatorsRepository;

    @Override
    public Indicators getIndicators(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return this.indicatorsRepository.findByUserId(userId);
    }
}
