package com.usermanager.users.services;

import com.usermanager.users.User;

import java.util.Optional;

@FunctionalInterface
public interface GetUserByEmailService {
    Optional<User> getUserByEmail(String email);

}
