package com.dsumtsov.microservices.currencyexchangeservice.service;

import com.dsumtsov.microservices.currencyexchangeservice.dto.CurrencyExchangeDTO;

public interface CurrencyExchangeService {
    CurrencyExchangeDTO retrieveExchangeValue(String from, String to);
}
