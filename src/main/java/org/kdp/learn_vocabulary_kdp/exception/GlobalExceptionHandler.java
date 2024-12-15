/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/15 - 16:18 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.kdp.learn_vocabulary_kdp.response.ApiResponse;
import org.kdp.learn_vocabulary_kdp.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

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

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handlerAccessDeniedException(AccessDeniedException e, HttpServletRequest request) {
        return ApiResponse.responseError(HttpStatus.FORBIDDEN, "You do not have permission to access this resource: " + request.getServletPath());
    }


    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    public ResponseEntity<ErrorResponse> handlerUnauthorizedException(HttpClientErrorException.Unauthorized e) {
        return ApiResponse.responseError(HttpStatus.UNAUTHORIZED, e.getMessage());
    }
}
