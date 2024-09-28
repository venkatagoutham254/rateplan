package com.example.rateplanmicroservice.exceptions;

@SuppressWarnings("serial")
public class RatePlanNotFoundException extends RuntimeException {
    public RatePlanNotFoundException(String message) {
        super(message);
    }
}
