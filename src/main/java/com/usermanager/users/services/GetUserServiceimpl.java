package com.usermanager.users.services;

import com.usermanager.users.User;
import com.usermanager.users.UserRepository;
import com.usermanager.users.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserServiceimpl implements GetUserService{

    private final UserRepository userRepository;

    public User getUser(Long userId){
        return this.userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }

}
