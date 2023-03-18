package ru.itis.controller.handlers;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import ru.itis.exception.ProjectServiceException;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class ValidationErrorMessage extends ProjectServiceException {

    private final String fieldName;
    private final String code;
    private final String detailMessage;

    public ValidationErrorMessage(HttpStatus httpStatus, String message, String fieldName, String code, String detailMessage) {
        super(httpStatus, message);
        this.fieldName = fieldName;
        this.code = code;
        this.detailMessage = detailMessage;
    }
}
