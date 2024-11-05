package org.kdp.learn_vocabulary_kdp.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ApiResponse {
    public static ResponseEntity<Object> responseBuilder(HttpStatus httpStatus, String message, Object responseObject) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", httpStatus.value());
        response.put("message", message);
        response.put("response", responseObject);

        return new ResponseEntity<>(response, httpStatus);
    }

    public static ResponseEntity<ErrorResponse> responseError(HttpStatus httpStatus, String message)
    {
        ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(),
                message);
        return new ResponseEntity<>(errorResponse,httpStatus);
    }
}
