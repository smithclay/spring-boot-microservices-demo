package com.dsumtsov.microservices.limitsservice.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("limits-service")
public class LimitsProperties {
    private int min;
    private int max;
}
