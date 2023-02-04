package com.usermanager.permission.services;

import com.usermanager.permission.jpa.Permission;

@FunctionalInterface
public interface CreatePermissionService {
    Permission createPermission(Permission permission);
}
