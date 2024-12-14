/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/14 - 18:50 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.service.impl;

import lombok.AllArgsConstructor;
import org.kdp.learn_vocabulary_kdp.entity.User;
import org.kdp.learn_vocabulary_kdp.exception.InvalidException;
import org.kdp.learn_vocabulary_kdp.exception.NotFoundException;
import org.kdp.learn_vocabulary_kdp.message.UserMessage;
import org.kdp.learn_vocabulary_kdp.model.dto.request.auth.LoginRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.user.UserCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.user.UserResponse;
import org.kdp.learn_vocabulary_kdp.model.mapper.UserMapper;
import org.kdp.learn_vocabulary_kdp.repository.UserRepository;
import org.kdp.learn_vocabulary_kdp.service.interfaces.AuthService;
import org.kdp.learn_vocabulary_kdp.service.interfaces.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    UserService userService;
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    UserMapper userMapper;

    @Override
    public UserResponse login(LoginRequest request) throws InvalidException {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new NotFoundException(UserMessage.EMAIL_PASSWORD_INCORRECT));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new InvalidException(UserMessage.EMAIL_PASSWORD_INCORRECT);
        }

        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse register(UserCreationRequest userCreationRequest) {
        return userService.createUser(userCreationRequest);
    }
}
