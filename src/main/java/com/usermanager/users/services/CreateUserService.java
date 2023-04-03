package com.usermanager.users.services;

import com.usermanager.users.User;
import com.usermanager.users.dto.UserRegisterDTO;

@FunctionalInterface
public interface CreateUserService {
    User createUser(UserRegisterDTO user);
}
