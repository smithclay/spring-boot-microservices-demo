package com.dsumtsov.microservices.currencyconversionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LimitsConfigurationDTO {
    private int min;
    private int max;
}
