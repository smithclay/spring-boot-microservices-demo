package com.dsumtsov.microservices.currencyexchange.service.impl;

import com.dsumtsov.microservices.currencyexchange.entity.CurrencyExchange;
import com.dsumtsov.microservices.currencyexchange.exception.ExchangeNotFoundException;
import com.dsumtsov.microservices.currencyexchange.dto.CurrencyExchangeDTO;
import com.dsumtsov.microservices.currencyexchange.repository.CurrencyExchangeRepository;
import com.dsumtsov.microservices.currencyexchange.service.CurrencyExchangeService;
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
