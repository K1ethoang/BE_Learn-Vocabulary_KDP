/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/17 - 23:46 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.response;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiResponse {
    public static ResponseEntity<Object> responseBuilder(HttpStatusCode httpStatus, String message, Object responseObject) {
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", httpStatus.value());
        response.put("message", message);
        response.put("result", responseObject);

        return new ResponseEntity<>(response, httpStatus);
    }

    public static ResponseEntity<ErrorResponse> responseError(HttpStatusCode httpStatus, String message) {
        ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), List.of(new ErrorDetail("general", message)));
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    public static ResponseEntity<ErrorResponse> responseError(HttpStatusCode httpStatus, List<ErrorDetail> errorDetails) {
        ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), errorDetails);

        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}
