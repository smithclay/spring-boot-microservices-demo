package com.dsumtsov.microservices.currencyexchangeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyExchangeDTO {
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;
}
