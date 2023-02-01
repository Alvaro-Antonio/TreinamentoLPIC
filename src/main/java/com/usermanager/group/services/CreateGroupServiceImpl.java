package com.usermanager.group.services;

import com.usermanager.group.GroupRepository;
import com.usermanager.group.jpa.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateGroupServiceImpl implements CreateGroupService {

    private final GroupRepository groupRepository;


    @Override
    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }
}