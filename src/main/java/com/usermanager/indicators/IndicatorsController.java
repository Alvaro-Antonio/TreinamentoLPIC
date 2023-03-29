package com.usermanager.indicators;

import com.usermanager.indicators.jpa.Indicators;
import com.usermanager.indicators.services.GetIndicatorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/user/{userId}/indicators")
public class IndicatorsController {

    private final GetIndicatorsService indicatorsService;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    public Indicators getIndicators(@PathVariable Long userId) {

        return indicatorsService.getIndicators(userId);
    }
}
