package com.dsumtsov.microservices.currencyconversionservice.service;

import com.dsumtsov.microservices.currencyconversionservice.dto.CurrencyConversionDTO;

import java.math.BigDecimal;

public interface CurrencyConversionService {
    CurrencyConversionDTO convertCurrency(String from, String to, BigDecimal quantity);
}
