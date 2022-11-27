package com.dsumtsov.microservices.limits.controller;

import com.dsumtsov.microservices.limits.service.LimitsConfigurationService;
import com.dsumtsov.microservices.limits.dto.LimitsConfigurationDTO;
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
