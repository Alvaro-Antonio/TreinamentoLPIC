package com.usermanager.simulated;

import com.usermanager.simulated.DTO.simulated.AnswerDTO;
import com.usermanager.simulated.DTO.simulated.QuestionWithAlternativesDTO;
import com.usermanager.simulated.DTO.simulated.SimulatedAnswersDTO;
import com.usermanager.simulated.services.simulated.GetSimulatedService;
import com.usermanager.simulated.services.simulated.ValuerSimulatedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/user/{userId}/simulated")
@CrossOrigin(origins = "http://localhost:4200")
public class SimulatedController {

    public final GetSimulatedService getSimulatedService;
    public final ValuerSimulatedService valuerSimulatedService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<QuestionWithAlternativesDTO> listQuestionsWithAlternatives(@PathVariable Long userId, @RequestParam int amount){
        return getSimulatedService.getQuestionsWithAlternatives(amount);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public SimulatedAnswersDTO calculateSimulated(@PathVariable Long userId,@Valid @RequestBody List<AnswerDTO> answers){
        return valuerSimulatedService.simulatedAnswers(userId, answers);
    }
}
