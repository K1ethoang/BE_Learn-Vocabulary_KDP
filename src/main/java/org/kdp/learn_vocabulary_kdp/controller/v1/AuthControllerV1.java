/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/22 - 23:53 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.controller.v1;

import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kdp.learn_vocabulary_kdp.message.GlobalMessage;
import org.kdp.learn_vocabulary_kdp.model.dto.request.auth.LoginRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.auth.ResetPasswordRequest;
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
        authService.register(userCreationRequest);
        return ApiResponse.createSuccessResponse(
                HttpStatus.CREATED, GlobalMessage.EMAIL_SENT, null);
    }

    @PostMapping("/verify-account")
    public ResponseEntity<Object> verifyToken(@RequestParam String token, @RequestParam String email) {
        authService.verifyToken(token, email);
        return ApiResponse.createSuccessResponse(HttpStatus.OK,
                GlobalMessage.SUCCESSFULLY, null);
    }

    @PostMapping("/resend-verify-token")
    public ResponseEntity<Object> resendVerifyToken(@RequestParam String email) throws MessagingException {
        authService.resendVerifyToken(email);
        return ApiResponse.createSuccessResponse(HttpStatus.OK, GlobalMessage.EMAIL_SENT, null);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<Object> forgotPassword(@RequestParam String email) throws MessagingException {
        authService.forgotPassword(email);
        return ApiResponse.createSuccessResponse(HttpStatus.OK, GlobalMessage.EMAIL_SENT, null);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Object> resetPassword(@Valid @RequestBody ResetPasswordRequest request, @RequestParam String token) {
        authService.resetPassword(request, token);
        return ApiResponse.createSuccessResponse(HttpStatus.OK, GlobalMessage.SUCCESSFULLY, null);
    }
}
