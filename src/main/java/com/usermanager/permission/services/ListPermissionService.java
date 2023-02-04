package com.usermanager.permission.services;

import com.usermanager.permission.jpa.Permission;

import java.util.List;

@FunctionalInterface
public interface ListPermissionService {
    public List<Permission> list();
}
