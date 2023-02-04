package com.usermanager.group.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GroupNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 5363539824266706614L;
    private static final String GROUP_NOT_FOUND = "Group not found!";

    public GroupNotFoundException(){
        super(GROUP_NOT_FOUND);
    }

}
