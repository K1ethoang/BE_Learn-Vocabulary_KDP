/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/15 - 15:22 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kdp.learn_vocabulary_kdp.Util.ContextHolderUtil;
import org.kdp.learn_vocabulary_kdp.entity.Role;
import org.kdp.learn_vocabulary_kdp.entity.User;
import org.kdp.learn_vocabulary_kdp.enums.ERole;
import org.kdp.learn_vocabulary_kdp.exception.InvalidException;
import org.kdp.learn_vocabulary_kdp.exception.NotFoundException;
import org.kdp.learn_vocabulary_kdp.message.UserMessage;
import org.kdp.learn_vocabulary_kdp.model.dto.request.user.UserCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.user.UserUpdateRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.user.UserResponse;
import org.kdp.learn_vocabulary_kdp.model.mapper.UserMapper;
import org.kdp.learn_vocabulary_kdp.repository.RoleRepository;
import org.kdp.learn_vocabulary_kdp.repository.UserRepository;
import org.kdp.learn_vocabulary_kdp.service.interfaces.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    PasswordEncoder passwordEncoder;
    UserRepository userRepository;
    UserMapper userMapper;
    RoleRepository roleRepository;
    ContextHolderUtil contextHolderUtil;

    @Override
    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll();

        List<UserResponse> userResponses = new ArrayList<>();

        users.forEach(user -> userResponses.add(userMapper.toUserResponse(user)));

        return userResponses;
    }

    @Override
    public UserResponse getUserById(String userId) throws NotFoundException {
        return userMapper.toUserResponse(userRepository.findById(userId).orElseThrow(() -> new NotFoundException(UserMessage.USER_NOT_FOUND)));
    }

    @Override
    public UserResponse createUser(UserCreationRequest userCreationRequest) throws InvalidException {
        if (userRepository.existsUserByEmail(userCreationRequest.getEmail())) {
            throw new InvalidException(UserMessage.EMAIL_EXIST);
        }

        User user = userMapper.toUser(userCreationRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setIsBlocked(false);

        Role role = roleRepository.findByName(ERole.USER.getName());
        role.setName(ERole.USER.getName());
        user.setRole(role);

        userRepository.save(user);

        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse updateUser(UserUpdateRequest userUpdateRequest, String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException(UserMessage.USER_NOT_FOUND));

        userMapper.updateUser(userUpdateRequest, user);

        userRepository.save(user);

        return userMapper.toUserResponse(user);
    }

    @Override
    public void deleteUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException(UserMessage.USER_NOT_FOUND));

        userRepository.delete(user);
    }

    @Override
    public UserResponse getMyInfo() throws NotFoundException {
        User user = userRepository.findByEmail(contextHolderUtil.getNameFromContext()).orElseThrow(() -> new NotFoundException(UserMessage.USER_NOT_FOUND));

        return userMapper.toUserResponse(user);
    }
}
