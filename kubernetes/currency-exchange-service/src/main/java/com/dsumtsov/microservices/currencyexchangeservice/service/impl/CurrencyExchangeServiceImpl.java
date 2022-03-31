package com.dsumtsov.microservices.currencyexchangeservice.service.impl;

import com.dsumtsov.microservices.currencyexchangeservice.dto.CurrencyExchangeDTO;
import com.dsumtsov.microservices.currencyexchangeservice.exception.ExchangeNotFoundException;
import com.dsumtsov.microservices.currencyexchangeservice.entity.CurrencyExchange;
import com.dsumtsov.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import com.dsumtsov.microservices.currencyexchangeservice.service.CurrencyExchangeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    private final CurrencyExchangeRepository repository;
    private final Environment environment;

    @Override
    public CurrencyExchangeDTO retrieveExchangeValue(String from, String to) {

        CurrencyExchange exchangeValue = repository.findByFromAndTo(from, to)
                .orElseThrow(() -> new ExchangeNotFoundException("No exchange value found"));

        return new CurrencyExchangeDTO(
                exchangeValue.getFrom(),
                exchangeValue.getTo(),
                exchangeValue.getConversionMultiple(),
                environment.getProperty("local.server.port")
        );
    }
}
