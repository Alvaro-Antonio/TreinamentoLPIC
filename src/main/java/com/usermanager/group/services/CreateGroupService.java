package com.usermanager.group.services;

import com.usermanager.group.jpa.Group;

@FunctionalInterface
public interface CreateGroupService {
    Group createGroup(Group group);
}
