package ru.itis.exception;

import org.springframework.http.HttpStatus;

public class UserExistException extends ProjectServiceException{
    public UserExistException() {
        super(HttpStatus.BAD_REQUEST, "user already exist");
    }
}
