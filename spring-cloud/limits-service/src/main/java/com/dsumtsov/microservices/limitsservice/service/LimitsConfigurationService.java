package com.dsumtsov.microservices.limitsservice.service;

import com.dsumtsov.microservices.limitsservice.dto.LimitsConfigurationDTO;

public interface LimitsConfigurationService {
    LimitsConfigurationDTO retrieveLimitsFromConfiguration();
}
