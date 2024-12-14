/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/14 - 21:13 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.service.interfaces;

import org.kdp.learn_vocabulary_kdp.model.dto.request.user.UserCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.user.UserUpdateRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.user.UserResponse;
import org.springframework.security.access.prepost.PostAuthorize;

import java.util.List;

public interface UserService {
    List<UserResponse> getUsers();

    UserResponse getUserById(String userId);

    UserResponse createUser(UserCreationRequest userCreationRequest);

    @PostAuthorize("returnObject.email == authentication.name")
    UserResponse updateUser(UserUpdateRequest userUpdateRequest, String userId);

    void deleteUser(String userId);

    @PostAuthorize("returnObject.email == authentication.name")
    UserResponse getMyInfo();
}
