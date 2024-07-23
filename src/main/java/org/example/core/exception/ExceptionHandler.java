package org.example.core.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
@RestControllerAdvice
@Slf4j
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Error> handle(Exception exception) {
        log.error("Failed to process request", exception);
        return ResponseEntity.status(getHttpStatus(exception)).body(new Error(exception.getMessage()));
    }

    private static HttpStatus getHttpStatus(Exception exception){
        if (exception instanceof IntervalNotFoundException){
            return HttpStatus.NOT_FOUND;
        }
        if (exception instanceof WrongIntervalException){
            return HttpStatus.BAD_REQUEST;
        }
        if (exception instanceof WrongKindException){
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
