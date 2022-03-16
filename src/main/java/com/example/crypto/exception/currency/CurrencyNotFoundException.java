package com.example.crypto.exception.currency;

public class CurrencyNotFoundException extends RuntimeException{
    public CurrencyNotFoundException(String message) {
        super(message);
    }
}
