/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/14 - 11:22 AM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.exception;

import org.kdp.learn_vocabulary_kdp.response.ApiResponse;
import org.kdp.learn_vocabulary_kdp.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // System exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerException(Exception e) {
        return ApiResponse.responseError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    @ExceptionHandler(InvalidException.class)
    public ResponseEntity<ErrorResponse> handlerInvalidException(InvalidException e) {
        return ApiResponse.responseError(e.getHttpStatus(), e.getMessage());
    }

    @ExceptionHandler(NotNullException.class)
    public ResponseEntity<ErrorResponse> handlerNotNullException(NotNullException e) {
        return ApiResponse.responseError(e.getHttpStatus(), e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerNotFoundException(NotFoundException e) {
        return ApiResponse.responseError(e.getHttpStatus(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handlerInvalidException(MethodArgumentNotValidException e) {
        return ApiResponse.responseError(e.getStatusCode(), e.getAllErrors().get(0).getDefaultMessage());
    }
}
