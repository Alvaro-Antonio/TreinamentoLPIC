package com.usermanager.users.services;

import com.usermanager.users.User;

@FunctionalInterface
public interface GetUserService {

    User getUser(Long userId);

}
