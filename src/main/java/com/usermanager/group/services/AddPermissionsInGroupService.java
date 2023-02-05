package com.usermanager.group.services;

import com.usermanager.permission.jpa.Permission;

import java.util.List;

@FunctionalInterface
public interface AddPermissionsInGroupService {
    void addPermissions(List<Permission> permissions,Long idGroup);
}
