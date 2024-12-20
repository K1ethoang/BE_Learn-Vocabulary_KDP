/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/20 - 22:29 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.model.mapper;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.entity.User;
import org.kdp.learn_vocabulary_kdp.model.dto.request.user.UserCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.user.UserUpdateRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.user.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserMapper {
    ModelMapper modelMapper;

    public void updateUser(UserUpdateRequest userUpdateRequest, User user) {
        modelMapper.map(userUpdateRequest, user);
    }

    public User toUser(UserCreationRequest userCreationRequest) {
        return modelMapper.map(userCreationRequest, User.class);
    }

    public UserResponse toUserResponse(User user) {
        return modelMapper.map(user, UserResponse.class);
    }
}
