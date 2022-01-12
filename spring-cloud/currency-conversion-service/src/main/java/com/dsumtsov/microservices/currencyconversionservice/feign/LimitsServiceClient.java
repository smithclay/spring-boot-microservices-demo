package com.dsumtsov.microservices.currencyconversionservice.feign;

import com.dsumtsov.microservices.currencyconversionservice.dto.LimitsConfigurationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="limits-service")
public interface LimitsServiceClient {
    @GetMapping("/limits")
    LimitsConfigurationDTO retrieveLimits();
}
