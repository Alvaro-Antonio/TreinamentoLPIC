package com.usermanager.simulated;

import com.usermanager.simulated.DTO.alternative.AlternativeCreateDTO;
import com.usermanager.simulated.jpa.Alternative;

import com.usermanager.simulated.services.alternative.CreateAlternativeService;
import com.usermanager.simulated.services.alternative.GetAlternativeService;
import com.usermanager.simulated.services.alternative.ListAlternativeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/user/{userId}/question/{questionId}/alternative/")
public class AlternativeController {
    private final CreateAlternativeService createAlternativeService;
    private final GetAlternativeService getAlternativeService;
    private final ListAlternativeService listAlternativeService;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Alternative createAlternative(@Valid @RequestBody AlternativeCreateDTO alternativeCreateDTO, @PathVariable Long userId, @PathVariable Long questionId){
        return createAlternativeService.createAlternative(userId, questionId, alternativeCreateDTO);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "{alternativeId}")
    public Alternative getAlternative(@PathVariable Long userId, @PathVariable Long questionId, @PathVariable Long alternativeId){

        return getAlternativeService.getAlternative(userId, questionId, alternativeId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Alternative> listAlternative (@PathVariable Long userId, @PathVariable Long questionId){

        return listAlternativeService.listAlternative(userId, questionId);
    }
}
