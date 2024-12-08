/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/07 - 01:13 AM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.controller.v1;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kdp.learn_vocabulary_kdp.message.GlobalMessage;
import org.kdp.learn_vocabulary_kdp.model.dto.auth.LoginDto;
import org.kdp.learn_vocabulary_kdp.model.dto.auth.RegisterDto;
import org.kdp.learn_vocabulary_kdp.response.ApiResponse;
import org.kdp.learn_vocabulary_kdp.service.interfaces.AuthService;
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

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginDto loginDto) {
        log.info("AuthControllerV1::login request body {}", loginDto);
        authService.login(loginDto);
        return ApiResponse.responseBuilder(HttpStatus.OK, GlobalMessage.SUCCESSFULLY, null);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterDto registerDto) {
        log.info("AuthControllerV1::register request body {}", registerDto);
        authService.register(registerDto);
        return ApiResponse.responseBuilder(HttpStatus.CREATED, GlobalMessage.SUCCESSFULLY, null);
    }
}
