/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/22 - 16:58 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.controller.v1;

import jakarta.mail.MessagingException;
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
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/auth")
@RestController
@AllArgsConstructor
@Slf4j
public class AuthControllerV1 {
    AuthService authService;
    JwtService jwtService;

    @PostMapping("/log-in")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginRequest request) throws MessagingException {
        UserResponse userResponse = authService.login(request);
        return ApiResponse.createSuccessResponse(
                HttpStatus.OK, GlobalMessage.SUCCESSFULLY, jwtService.generateToken(userResponse));
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@Valid @RequestBody UserCreationRequest userCreationRequest)
            throws MessagingException {
        return ApiResponse.createSuccessResponse(
                HttpStatus.CREATED, GlobalMessage.SUCCESSFULLY, authService.register(userCreationRequest));
    }

    @PostMapping("/verify-account")
    public ResponseEntity<Object> verifyToken(@RequestParam String token, @RequestParam String email) {
        authService.verifyToken(token, email);
        return ApiResponse.createSuccessResponse(HttpStatus.OK, GlobalMessage.SUCCESSFULLY, null);
    }

    @PostMapping("/resend-verify-token")
    public ResponseEntity<Object> resendVerifyToken(@RequestParam String email) throws MessagingException {
        authService.resendVerifyToken(email);
        return ApiResponse.createSuccessResponse(HttpStatus.OK, GlobalMessage.SUCCESSFULLY, null);
    }
}
