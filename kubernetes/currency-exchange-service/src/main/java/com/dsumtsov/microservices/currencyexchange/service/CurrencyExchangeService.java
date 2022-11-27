package com.dsumtsov.microservices.currencyexchange.service;

import com.dsumtsov.microservices.currencyexchange.dto.CurrencyExchangeDTO;

public interface CurrencyExchangeService {
    CurrencyExchangeDTO retrieveExchangeValue(String from, String to);
}
