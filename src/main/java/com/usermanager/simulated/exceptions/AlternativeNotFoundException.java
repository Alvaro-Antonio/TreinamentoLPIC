package com.usermanager.simulated.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlternativeNotFoundException extends RuntimeException{

    private static final String ALTERNATIVE_NOT_FOUND = "Alternative not found!";

    @Serial
    private static final long serialVersionUID = -4753271447794656630L;

    public AlternativeNotFoundException() {
        super(ALTERNATIVE_NOT_FOUND);
    }
}
