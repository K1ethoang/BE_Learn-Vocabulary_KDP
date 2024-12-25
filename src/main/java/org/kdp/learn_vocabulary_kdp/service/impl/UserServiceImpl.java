/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/25 - 17:13 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.impl;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.kdp.learn_vocabulary_kdp.Util.ContextHolderUtil;
import org.kdp.learn_vocabulary_kdp.entity.Role;
import org.kdp.learn_vocabulary_kdp.entity.User;
import org.kdp.learn_vocabulary_kdp.enums.ERole;
import org.kdp.learn_vocabulary_kdp.exception.InvalidException;
import org.kdp.learn_vocabulary_kdp.exception.NotFoundException;
import org.kdp.learn_vocabulary_kdp.message.UserMessage;
import org.kdp.learn_vocabulary_kdp.model.dto.paging.PageableDto;
import org.kdp.learn_vocabulary_kdp.model.dto.request.user.UserCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.user.UserUpdateRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.user.UserResponse;
import org.kdp.learn_vocabulary_kdp.model.mapper.UserMapper;
import org.kdp.learn_vocabulary_kdp.repository.RoleRepository;
import org.kdp.learn_vocabulary_kdp.repository.UserRepository;
import org.kdp.learn_vocabulary_kdp.service.interfaces.MailService;
import org.kdp.learn_vocabulary_kdp.service.interfaces.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {
    PasswordEncoder passwordEncoder;
    UserRepository userRepository;
    UserMapper userMapper;
    RoleRepository roleRepository;
    ContextHolderUtil contextHolderUtil;
    MailService mailService;

    private User getUser(String userId) throws NotFoundException, AccessDeniedException {
        String userIdFromContext = contextHolderUtil.getUserIdFromContext();

        if (contextHolderUtil.getRoleFromContext().equals(ERole.ADMIN.toString())) {
            return userRepository.findById(userId).orElseThrow(() -> new NotFoundException(UserMessage.USER_NOT_FOUND));
        }

        if (!userId.equals(userIdFromContext)) {
            throw new AccessDeniedException("");
        }

        return userRepository.findById(userId).orElseThrow(() -> new NotFoundException(UserMessage.USER_NOT_FOUND));
    }

    @Override
    public PageableDto getUsers(Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);

        List<UserResponse> content =
                userPage.getContent().stream().map(userMapper::toUserResponse).toList();

        PageableDto pageableDto = new PageableDto(userPage);

        pageableDto.setContent(Arrays.asList(content.toArray()));

        return pageableDto;
    }

    @Override
    public UserResponse getUserById(String userId) {
        return userMapper.toUserResponse(getUser(userId));
    }

    @Override
    public UserResponse createUser(UserCreationRequest userCreationRequest) throws InvalidException {
        if (userRepository.existsUserByEmail(userCreationRequest.getEmail())) {
            throw new InvalidException(UserMessage.EMAIL_EXIST);
        }

        User user = userMapper.toUser(userCreationRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEmail(userCreationRequest.getEmail().toLowerCase());

        Role role = roleRepository.findByName(ERole.USER.getName());
        role.setName(ERole.USER.getName());
        user.setRole(role);

        userRepository.save(user);

        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse updateUser(@Valid UserUpdateRequest userUpdateRequest, String userId) throws InvalidException {
        User user = getUser(userId);

        userMapper.updateUser(userUpdateRequest, user);

        user.setEmail(user.getEmail().toLowerCase());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return userMapper.toUserResponse(user);
    }

    @Override
    public void deleteUser(String userId) {
        User user = getUser(userId);

        userRepository.delete(user);
    }

    @Override
    public UserResponse toggleBlockUser(String userId, boolean isBlocked) {
        User user = getUser(userId);

        user.setIsBlock(isBlocked);
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse getMyInfo() throws NotFoundException {
        User user = userRepository
                .findByEmail(contextHolderUtil.getNameFromContext())
                .orElseThrow(() -> new NotFoundException(UserMessage.USER_NOT_FOUND));

        return userMapper.toUserResponse(user);
    }
}
