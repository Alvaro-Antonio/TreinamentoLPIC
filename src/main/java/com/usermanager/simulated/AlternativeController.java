package com.usermanager.simulated;

import com.usermanager.simulated.DTO.alternative.AlternativeCreateDTO;
import com.usermanager.simulated.jpa.Alternative;

import com.usermanager.simulated.services.alternative.CreateAlternativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/user/{userId}/question/{questionId}/alternative")
public class AlternativeController {
    private final CreateAlternativeService createAlternativeService;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Alternative createAlternative(@Valid @RequestBody AlternativeCreateDTO alternativeCreateDTO, @PathVariable Long userId, @PathVariable Long questionId){
        return createAlternativeService.createAlternative(userId, questionId, alternativeCreateDTO);
    }
}
