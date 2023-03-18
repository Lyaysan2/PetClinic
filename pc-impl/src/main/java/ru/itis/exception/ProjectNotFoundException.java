package ru.itis.exception;

import org.springframework.http.HttpStatus;

public class ProjectNotFoundException extends ProjectServiceException{

    public ProjectNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}