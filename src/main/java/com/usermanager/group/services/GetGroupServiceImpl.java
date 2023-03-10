package com.usermanager.group.services;

import com.usermanager.group.Exceptions.GroupNotFoundException;
import com.usermanager.group.GroupRepository;
import com.usermanager.group.dto.GroupCreateDTO;
import com.usermanager.group.jpa.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GetGroupServiceImpl implements GetGroupService {

    private final GroupRepository groupRepository;


    public Group getGroup(Long id) {
        return groupRepository.findById(id).orElseThrow(GroupNotFoundException::new);
    }
}