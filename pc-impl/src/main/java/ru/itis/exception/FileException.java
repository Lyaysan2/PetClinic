package ru.itis.exception;

import org.springframework.http.HttpStatus;

public class FileException extends ProjectServiceException{

    public FileException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
