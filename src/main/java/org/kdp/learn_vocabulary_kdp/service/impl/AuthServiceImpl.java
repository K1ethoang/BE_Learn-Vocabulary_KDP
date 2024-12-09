/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/09 - 23:36 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.service.impl;

import lombok.AllArgsConstructor;
import org.kdp.learn_vocabulary_kdp.entity.User;
import org.kdp.learn_vocabulary_kdp.exception.InvalidException;
import org.kdp.learn_vocabulary_kdp.model.dto.auth.LoginDto;
import org.kdp.learn_vocabulary_kdp.model.dto.auth.RegisterDto;
import org.kdp.learn_vocabulary_kdp.repository.UserRepository;
import org.kdp.learn_vocabulary_kdp.service.interfaces.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public void login(LoginDto loginDto) throws InvalidException {
        User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(() -> new InvalidException("Email or password is incorrect"));

        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new InvalidException("Email or password is incorrect");
        }
    }

    @Override
    public void register(RegisterDto registerDto) throws InvalidException {
        User user = User.builder().email(registerDto.getEmail()).password(registerDto.getPassword()).fullName(registerDto.getFullName()).build();
        userRepository.save(user);

        // Todo: modify check user with email
        if (user.getId() == null) {
            throw new InvalidException("User is duplicated");
        }
    }
}
