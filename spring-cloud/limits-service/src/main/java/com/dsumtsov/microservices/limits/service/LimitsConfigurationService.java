package com.dsumtsov.microservices.limits.service;

import com.dsumtsov.microservices.limits.dto.LimitsConfigurationDTO;

public interface LimitsConfigurationService {
    LimitsConfigurationDTO retrieveLimitsFromConfiguration();
}
