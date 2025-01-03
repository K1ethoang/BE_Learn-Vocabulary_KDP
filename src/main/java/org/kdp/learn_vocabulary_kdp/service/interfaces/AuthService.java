/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/22 - 23:53 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.interfaces;

import jakarta.mail.MessagingException;
import org.kdp.learn_vocabulary_kdp.model.dto.request.auth.LoginRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.auth.ResetPasswordRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.user.UserCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.user.UserResponse;

public interface AuthService {
    UserResponse login(LoginRequest request) throws MessagingException;

    void register(UserCreationRequest userCreationRequest) throws MessagingException;

    void verifyToken(String token, String email);

    void resendVerifyToken(String email) throws MessagingException;

    void forgotPassword(String email) throws MessagingException;

    void resetPassword(ResetPasswordRequest request, String token);
}
