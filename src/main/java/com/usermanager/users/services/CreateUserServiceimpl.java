package com.usermanager.users.services;

import com.sun.jdi.LongValue;
import com.usermanager.indicators.IndicatorsRepository;
import com.usermanager.indicators.jpa.Achievement;
import com.usermanager.indicators.jpa.Indicators;
import com.usermanager.users.User;
import com.usermanager.users.UserRepository;
import com.usermanager.users.dto.UserRegisterDTO;
import com.usermanager.users.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class CreateUserServiceimpl implements CreateUserService{

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final IndicatorsRepository indicatorsRepository;
    @Override
    public User createUser(UserRegisterDTO userRegister) {
        User user = User.from(userRegister);
        user.setPassword(bCryptPasswordEncoder.encode(userRegister.getPassword()));
        user.setCreationDate(LocalDateTime.now());

        User user1 = this.userRepository.save(user);

        Indicators indicators = new Indicators();
        indicators.setUser(user);
        indicators.setScore(Long.parseLong("0"));
        indicators.setAchievements(new HashSet<Achievement>());
        indicatorsRepository.save(indicators);

        user1.setIndicators(indicators);

        return userRepository.save(user1);
    }

}
