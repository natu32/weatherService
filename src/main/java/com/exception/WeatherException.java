package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WeatherException extends RuntimeException {

    public WeatherException(String msg, Throwable t) {
        super(msg, t);
    }
}
