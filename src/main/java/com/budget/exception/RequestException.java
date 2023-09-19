package com.budget.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = false)
public class RequestException extends RuntimeException {
    private String code;
    private HttpStatus status;

    public RequestException(String message, String code, HttpStatus status) {
        super(message);
        this.code = code;
        this.status = status;
    }

    public RequestException(String message, String code) {
        super(message);
        this.code = code;
    }

    public RequestException(String message) {
        super(message);
    }
}
