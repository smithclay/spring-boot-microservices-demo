package com.dsumtsov.microservices.limits.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("app.limits")
public class LimitsProperties {
    private int min;
    private int max;
}
