package com.dsumtsov.microservices.currencyconversion.feign;

import com.dsumtsov.microservices.currencyconversion.dto.LimitsConfigurationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "limits-service", url = "${app.limits.url}")
public interface LimitsServiceClient {
    @GetMapping("/limits")
    LimitsConfigurationDTO retrieveLimits();
}
