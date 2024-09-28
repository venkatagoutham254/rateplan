package com.example.rateplanmicroservice.exceptions;

@SuppressWarnings("serial")
public class ProducerNotFoundException extends RuntimeException {
    public ProducerNotFoundException(String message) {
        super(message);
    }
}
