package com.usermanager.group.services;

import com.usermanager.group.jpa.Group;

import java.util.List;

@FunctionalInterface
public interface ListGroupService {
    List<Group> getGroup();
}
