package com.dsumtsov.microservices.limitsservice.controller;

import com.dsumtsov.microservices.limitsservice.dto.LimitsConfigurationDTO;
import com.dsumtsov.microservices.limitsservice.service.LimitsConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LimitsConfigurationController {

    private final LimitsConfigurationService service;

    @GetMapping("/limits")
    public LimitsConfigurationDTO retrieveLimitsFromConfiguration() {
        return service.retrieveLimitsFromConfiguration();
    }
}
