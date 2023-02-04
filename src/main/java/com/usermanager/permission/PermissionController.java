package com.usermanager.permission;

import com.usermanager.permission.dto.PermissionCreateDTO;
import com.usermanager.permission.jpa.Permission;
import com.usermanager.permission.services.CreatePermissionService;
import com.usermanager.permission.services.ListPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
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
public class PermissionController {

    private final CreatePermissionService createPermissionService;
    private final ListPermissionService listPermissionService;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(value = "permission", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Permission createPermission(@Valid @RequestBody PermissionCreateDTO permissionCreateDTO){
        return createPermissionService.createPermission(Permission.from(permissionCreateDTO));
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "permission")
    public List<Permission> listPermissions() {
        return listPermissionService.list();
    }
}
