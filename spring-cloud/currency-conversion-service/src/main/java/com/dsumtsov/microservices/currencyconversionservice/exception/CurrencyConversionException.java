package com.dsumtsov.microservices.currencyconversionservice.exception;

public class CurrencyConversionException extends RuntimeException {
    public CurrencyConversionException(String message) {
        super(message);
    }
}
