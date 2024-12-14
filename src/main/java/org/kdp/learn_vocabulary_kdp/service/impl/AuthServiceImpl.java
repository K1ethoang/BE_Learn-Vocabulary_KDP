/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/14 - 11:47 AM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.service.impl;

import lombok.AllArgsConstructor;
import org.kdp.learn_vocabulary_kdp.entity.User;
import org.kdp.learn_vocabulary_kdp.exception.InvalidException;
import org.kdp.learn_vocabulary_kdp.message.UserMessage;
import org.kdp.learn_vocabulary_kdp.model.dto.request.auth.LoginRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.auth.RegisterDto;
import org.kdp.learn_vocabulary_kdp.model.dto.response.user.UserDto;
import org.kdp.learn_vocabulary_kdp.model.mapper.EntityToDto;
import org.kdp.learn_vocabulary_kdp.repository.UserRepository;
import org.kdp.learn_vocabulary_kdp.service.interfaces.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    EntityToDto entityToDto;

    @Override
    public UserDto login(LoginRequest request) throws InvalidException {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new InvalidException(UserMessage.EMAIL_PASSWORD_INCORRECT));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new InvalidException(UserMessage.EMAIL_PASSWORD_INCORRECT);
        }

        return entityToDto.userDto(user);
    }

    @Override
    public UserDto register(RegisterDto registerDto) throws InvalidException {
        if (userRepository.existsUserByEmail(registerDto.getEmail())) {
            throw new InvalidException(UserMessage.EMAIL_EXIST);
        }

        // todo: set default role is user
        User user = User.builder().email(registerDto.getEmail()).password(passwordEncoder.encode(registerDto.getPassword())).fullName(registerDto.getFullName()).isBlocked(false).build();

        return entityToDto.userDto(userRepository.save(user));
    }
}
