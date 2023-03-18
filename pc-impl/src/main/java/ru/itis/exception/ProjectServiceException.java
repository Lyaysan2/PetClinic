package ru.itis.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ProjectServiceException extends RuntimeException {

    private HttpStatus httpStatus;

    public ProjectServiceException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
