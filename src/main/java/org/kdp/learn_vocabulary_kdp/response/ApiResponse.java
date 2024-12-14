/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/14 - 11:44 AM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.response;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ApiResponse {
    public static ResponseEntity<Object> responseBuilder(HttpStatusCode httpStatus, String message, Object responseObject) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", httpStatus.value());
        response.put("message", message);
        response.put("result", responseObject);

        return new ResponseEntity<>(response, httpStatus);
    }

    public static ResponseEntity<ErrorResponse> responseError(HttpStatusCode httpStatus, String message) {
        ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), message);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}
