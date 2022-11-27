package com.dsumtsov.microservices.limits.service.impl;

import com.dsumtsov.microservices.limits.service.LimitsConfigurationService;
import com.dsumtsov.microservices.limits.config.properties.LimitsProperties;
import com.dsumtsov.microservices.limits.dto.LimitsConfigurationDTO;
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
