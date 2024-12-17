/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/18 - 00:25 AM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.kdp.learn_vocabulary_kdp.response.ApiResponse;
import org.kdp.learn_vocabulary_kdp.response.ErrorDetail;
import org.kdp.learn_vocabulary_kdp.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

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
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ErrorDetail> errorDetails = e.getBindingResult().getFieldErrors().stream().map(fieldError -> new ErrorDetail(fieldError.getField(), fieldError.getDefaultMessage())).toList();

        return ApiResponse.responseError(e.getStatusCode(), errorDetails);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException e) {
        List<ErrorDetail> errorDetails = e.getConstraintViolations().stream().map(violation -> {
            String fieldPath = violation.getPropertyPath().toString();
            return new ErrorDetail(fieldPath.substring(fieldPath.lastIndexOf('.') + 1), // Lấy tên field cuối cùng
                    violation.getMessage());
        }).toList();

        return ApiResponse.responseError(HttpStatus.BAD_REQUEST, errorDetails);
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
