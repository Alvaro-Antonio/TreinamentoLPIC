package com.usermanager.simulated;

import com.usermanager.simulated.DTO.simulated.QuestionWithAlternativesDTO;
import com.usermanager.simulated.services.simulated.GetSimulatedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/user/{userId}/simulated")
public class SimulatedController {

    public final GetSimulatedService getSimulatedService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<QuestionWithAlternativesDTO> listQuestionsWithAlternatives(@PathVariable Long userId, @RequestParam int amount){
        return getSimulatedService.getQuestionsWithAlternatives(amount);
    }
}
