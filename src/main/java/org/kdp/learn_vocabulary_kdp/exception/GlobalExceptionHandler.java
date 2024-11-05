package org.kdp.learn_vocabulary_kdp.exception;

import org.kdp.learn_vocabulary_kdp.response.ApiResponse;
import org.kdp.learn_vocabulary_kdp.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // System exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerException(Exception e) {
        return ApiResponse.responseError(HttpStatus.INTERNAL_SERVER_ERROR,
                e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerNotFoundException(NotFoundException e) {
        return ApiResponse.responseError(e.getHttpStatus(),
                e.getMessage());
    }

    @ExceptionHandler(InvalidException.class)
    public ResponseEntity<ErrorResponse> handlerInvalidException(InvalidException e){
        return ApiResponse.responseError(e.getHttpStatus(), e.getMessage());
    }
}
