package com.usermanager.group.services;

import com.usermanager.group.Exceptions.GroupNotFoundException;
import com.usermanager.group.GroupRepository;
import com.usermanager.group.jpa.Group;
import com.usermanager.permission.PermissionRepository;
import com.usermanager.permission.jpa.Permission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class AddPermissionInGroupServiceImpl implements AddPermissionsInGroupService {

    private final GroupRepository groupRepository;
    private final PermissionRepository permissionRepository;


    @Override
    public void addPermissions(List<Permission> permissions, Long idGroup) {
        Group group = groupRepository.findById(idGroup).orElseThrow(GroupNotFoundException::new);


        if (group.getPermissions() == null){
            Set<Permission> groupSet = new HashSet<>(permissions);
           group.setPermissions(groupSet);
        }else {
            group.getPermissions().addAll(permissions);
        }

        groupRepository.save(group);
    }
}