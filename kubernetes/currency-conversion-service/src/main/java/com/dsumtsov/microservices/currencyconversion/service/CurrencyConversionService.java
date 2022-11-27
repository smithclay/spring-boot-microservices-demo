package com.dsumtsov.microservices.currencyconversion.service;

import com.dsumtsov.microservices.currencyconversion.dto.CurrencyConversionDTO;

import java.math.BigDecimal;

public interface CurrencyConversionService {
    CurrencyConversionDTO convertCurrency(String from, String to, BigDecimal quantity);
}
