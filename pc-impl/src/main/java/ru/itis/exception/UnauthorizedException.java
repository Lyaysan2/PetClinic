package ru.itis.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends ProjectServiceException{
    public UnauthorizedException(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }
}
