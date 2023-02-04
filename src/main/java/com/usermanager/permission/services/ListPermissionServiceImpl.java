package com.usermanager.permission.services;

import com.usermanager.permission.PermissionRepository;
import com.usermanager.permission.jpa.Permission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ListPermissionServiceImpl implements ListPermissionService{

    private final PermissionRepository permissionRepository;
    @Override
    public List<Permission> list() {
        return permissionRepository.findAll();
    }
}
