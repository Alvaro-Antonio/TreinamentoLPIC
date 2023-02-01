package com.usermanager.group.services;

import com.usermanager.group.GroupRepository;
import com.usermanager.group.jpa.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetGroupServiceImpl implements GetGroupService {

    private final GroupRepository groupRepository;


    public List<Group> getGroup() {
        return groupRepository.findAll();
    }
}