package com.dsumtsov.microservices.currencyconversionservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private Date timestamp;
    private String message;
    private String details;
}
