package ru.itis.exception;

import org.springframework.http.HttpStatus;

public class ProjectBadRequestException extends ProjectServiceException{
    public ProjectBadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
