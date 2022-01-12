package com.dsumtsov.microservices.currencyexchangeservice.exception;

public class ExchangeNotFoundException extends RuntimeException {
    public ExchangeNotFoundException(String message) {
        super(message);
    }
}
