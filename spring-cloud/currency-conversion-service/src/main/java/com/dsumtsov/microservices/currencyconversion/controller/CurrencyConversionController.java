package com.dsumtsov.microservices.currencyconversion.controller;

import com.dsumtsov.microservices.currencyconversion.dto.CurrencyConversionDTO;
import com.dsumtsov.microservices.currencyconversion.service.CurrencyConversionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RestController
@Tag(name = "currency-conversion")
@RequestMapping("/currency-conversion")
@RequiredArgsConstructor
public class CurrencyConversionController {

    private final CurrencyConversionService service;

    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionDTO convertCurrency(@PathVariable String from,
                                                 @PathVariable String to,
                                                 @PathVariable BigDecimal quantity) {

        log.info("Convert currency request params: from={}, to={}, quantity={}", from, to, quantity);

        return service.convertCurrency(from, to, quantity);
    }
}
