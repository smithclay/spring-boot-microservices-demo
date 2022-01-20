package com.dsumtsov.microservices.limitsservice.service.impl;

import com.dsumtsov.microservices.limitsservice.config.properties.LimitsProperties;
import com.dsumtsov.microservices.limitsservice.dto.LimitsConfigurationDTO;
import com.dsumtsov.microservices.limitsservice.service.LimitsConfigurationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LimitsConfigurationServiceImpl implements LimitsConfigurationService {

    private final LimitsProperties properties;

    @Override
    public LimitsConfigurationDTO retrieveLimitsFromConfiguration() {
        log.info("Limits: min={}, max={}", properties.getMin(), properties.getMax());
        return new LimitsConfigurationDTO(properties.getMin(), properties.getMax());
    }
}
