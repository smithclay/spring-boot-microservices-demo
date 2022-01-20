package com.dsumtsov.microservices.currencyconversionservice.service.impl;

import com.dsumtsov.microservices.currencyconversionservice.dto.CurrencyConversionDTO;
import com.dsumtsov.microservices.currencyconversionservice.dto.CurrencyExchangeDTO;
import com.dsumtsov.microservices.currencyconversionservice.dto.LimitsConfigurationDTO;
import com.dsumtsov.microservices.currencyconversionservice.exception.CurrencyConversionException;
import com.dsumtsov.microservices.currencyconversionservice.feign.CurrencyExchangeServiceClient;
import com.dsumtsov.microservices.currencyconversionservice.feign.LimitsServiceClient;
import com.dsumtsov.microservices.currencyconversionservice.service.CurrencyConversionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

    private final CurrencyExchangeServiceClient currencyExchangeServiceClient;
    private final LimitsServiceClient limitsServiceClient;

    @Override
    public CurrencyConversionDTO convertCurrency(String from, String to, BigDecimal quantity) {

        CurrencyExchangeDTO currencyExchangeDTO = currencyExchangeServiceClient.retrieveExchangeValue(from, to);
        LimitsConfigurationDTO limitsDTO = limitsServiceClient.retrieveLimits();
        BigDecimal calculatedAmount = quantity.multiply(currencyExchangeDTO.getConversionMultiple());

        log.info("Convert currency: calculatedAmount={}, limits={}", calculatedAmount, limitsDTO);

        if (!isValidAmount(calculatedAmount, limitsDTO)) {
            throw new CurrencyConversionException(String.format(
                    "Calculated amount exceeds limits, calculatedAmount='%s', limits='%s'",
                    calculatedAmount,
                    limitsDTO)
            );
        }

        return new CurrencyConversionDTO(
                from,
                to,
                quantity,
                currencyExchangeDTO.getConversionMultiple(),
                calculatedAmount,
                currencyExchangeDTO.getEnvironment()
        );
    }

    private boolean isValidAmount(BigDecimal calculatedAmount, LimitsConfigurationDTO limitsDTO) {
        return calculatedAmount.compareTo(BigDecimal.valueOf(limitsDTO.getMin())) >= 0
                && calculatedAmount.compareTo(BigDecimal.valueOf(limitsDTO.getMax())) <= 0;
    }
}
