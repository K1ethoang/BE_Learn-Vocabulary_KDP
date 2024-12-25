/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/25 - 14:34 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.response;

import java.util.List;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse {
    public static ResponseEntity<Object> createSuccessResponse(
            HttpStatusCode httpStatus, String message, Object responseObject) {
        SuccessResponse successResponse = new SuccessResponse(httpStatus.value(), message, responseObject);

        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }

    public static ResponseEntity<ErrorResponse> createErrorResponse(HttpStatusCode httpStatus, String message) {
        ErrorResponse errorResponse =
                new ErrorResponse(httpStatus.value(), List.of(new ErrorDetail("general", message)));

        return ResponseEntity.status(httpStatus.value()).body(errorResponse);
    }

    public static ResponseEntity<ErrorResponse> createErrorResponse(
            HttpStatusCode httpStatus, List<ErrorDetail> errorDetails) {
        ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), errorDetails);

        return ResponseEntity.status(httpStatus.value()).body(errorResponse);
    }
}
