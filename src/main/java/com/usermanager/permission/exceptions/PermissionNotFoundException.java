package com.usermanager.permission.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PermissionNotFoundException extends RuntimeException{


    private static final long serialVersionUID = 2941901510477711551L;
    private static final String PERMISSION_NOT_FOUND = "Permission not Found!";

    public PermissionNotFoundException(){
        super(PERMISSION_NOT_FOUND);
    }
}
