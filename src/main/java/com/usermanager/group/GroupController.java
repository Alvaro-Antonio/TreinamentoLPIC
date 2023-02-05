package com.usermanager.group;

import com.usermanager.group.dto.GroupCreateDTO;
import com.usermanager.group.jpa.Group;
import com.usermanager.group.services.AddPermissionsInGroupService;
import com.usermanager.group.services.CreateGroupService;
import com.usermanager.group.services.GetGroupService;
import com.usermanager.group.services.ListGroupService;
import com.usermanager.permission.jpa.Permission;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/user/")
public class GroupController {

    private final CreateGroupService createGroupService;
    private final GetGroupService getGroupService;
    private final ListGroupService listGroupService;
    private final AddPermissionsInGroupService addPermissionsInGroupService;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "group")
    public List<Group> listGroups() {
        return listGroupService.getGroup();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(value = "group", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Group createGroup( @Valid @RequestBody GroupCreateDTO groupCreateDTO ) {
        return createGroupService.createGroup(Group.from(groupCreateDTO));
    }

    @ResponseStatus(code =  HttpStatus.OK)
    @GetMapping(value = "group/{id}")
    public Group getGroup(@PathVariable Long id){

        return getGroupService.getGroup(id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PatchMapping(value = "group/{idGroup}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addPermissions (@Valid @RequestBody List<Permission> permissions,
                                @PathVariable Long idGroup){
        addPermissionsInGroupService.addPermissions(permissions,idGroup);
    }
}
