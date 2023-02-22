package com.usermanager.simulated;

import com.usermanager.simulated.DTO.question.QuestionCreateDTO;
import com.usermanager.simulated.jpa.Question;
import com.usermanager.simulated.services.question.CreateQuestionService;
import com.usermanager.simulated.services.question.DeleteQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/user/{userId}/question")
public class QuestionController {
    private final CreateQuestionService createQuestionService;

    private final DeleteQuestionService deleteQuestionService;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Question createQuestion(@Valid @RequestBody QuestionCreateDTO questionCreateDTO, @PathVariable Long userId){
        return createQuestionService.createQuestion(userId, questionCreateDTO);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(value = "{questionId}")
    public void questionDelete (@PathVariable Long userId, @PathVariable Long questionId){
        deleteQuestionService.deleteQuestion(userId, questionId);
    }


}
