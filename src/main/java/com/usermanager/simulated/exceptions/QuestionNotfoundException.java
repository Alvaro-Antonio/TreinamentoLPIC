package com.usermanager.simulated.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QuestionNotfoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = -6379944723023258589L;

    private static final String QUESTION_NOT_FOUND = "Question not found!";


    public QuestionNotfoundException(){
        super(QUESTION_NOT_FOUND);
    }
}
