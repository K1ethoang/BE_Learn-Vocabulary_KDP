/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/20 - 23:05 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.controller.v1;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kdp.learn_vocabulary_kdp.message.GlobalMessage;
import org.kdp.learn_vocabulary_kdp.model.dto.request.auth.LoginRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.user.UserCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.user.UserResponse;
import org.kdp.learn_vocabulary_kdp.response.ApiResponse;
import org.kdp.learn_vocabulary_kdp.service.interfaces.AuthService;
import org.kdp.learn_vocabulary_kdp.service.interfaces.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/auth")
@RestController
@AllArgsConstructor
@Slf4j
public class AuthControllerV1 {
    AuthService authService;
    JwtService jwtService;

    @PostMapping("/log-in")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginRequest request) {
        UserResponse userResponse = authService.login(request);
        return ApiResponse.createSuccessResponse(
                HttpStatus.OK, GlobalMessage.SUCCESSFULLY, jwtService.generateToken(userResponse));
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@Valid @RequestBody UserCreationRequest userCreationRequest) {
        return ApiResponse.createSuccessResponse(
                HttpStatus.CREATED, GlobalMessage.SUCCESSFULLY, authService.register(userCreationRequest));
    }

    @Operation(summary = "Chưa có gì")
    @PostMapping("/log-out")
    public ResponseEntity<Object> logout() {
        return ApiResponse.createSuccessResponse(HttpStatus.CREATED, GlobalMessage.SUCCESSFULLY, null);
    }
}
