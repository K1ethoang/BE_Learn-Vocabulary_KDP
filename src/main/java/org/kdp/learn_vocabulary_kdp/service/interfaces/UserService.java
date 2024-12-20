/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/20 - 23:28 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.interfaces;

import jakarta.validation.Valid;
import org.kdp.learn_vocabulary_kdp.model.dto.paging.PageableDto;
import org.kdp.learn_vocabulary_kdp.model.dto.request.user.UserCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.user.UserUpdateRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.user.UserResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserService {
    PageableDto getUsers(Pageable pageable);

    UserResponse getUserById(String userId);

    UserResponse createUser(UserCreationRequest userCreationRequest);

    UserResponse updateUser(@Valid UserUpdateRequest userUpdateRequest, String userId);

    void deleteUser(String userId);

    UserResponse toggleBlockUser(String userId, boolean isBlocked);

    UserResponse getMyInfo();
}
