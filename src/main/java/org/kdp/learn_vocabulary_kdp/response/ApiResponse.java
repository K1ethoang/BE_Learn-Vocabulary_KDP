/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/18 - 02:10 AM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.response;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse {
    public static ResponseEntity<Object> createSuccessResponse(HttpStatusCode httpStatus, String message, Object responseObject) {
        SuccessResponse successResponse = new SuccessResponse(httpStatus.value(), message, responseObject);

        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }

    public static ResponseEntity<ErrorResponse> createErrorResponse(HttpStatusCode httpStatus, String message) {
        ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), List.of(new ErrorDetail("general", message)));
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    public static ResponseEntity<ErrorResponse> createErrorResponse(HttpStatusCode httpStatus, List<ErrorDetail> errorDetails) {
        ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), errorDetails);

        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}
