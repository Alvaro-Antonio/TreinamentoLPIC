package com.usermanager.permission.services;

import com.usermanager.group.GroupRepository;
import com.usermanager.group.jpa.Group;
import com.usermanager.group.services.CreateGroupService;
import com.usermanager.permission.PermissionRepository;
import com.usermanager.permission.jpa.Permission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreatePermissionServiceImpl implements CreatePermissionService {

    private final PermissionRepository permissionRepository;

    @Override
    public Permission createPermission(Permission permission) {
        return permissionRepository.save(permission);
    }
}