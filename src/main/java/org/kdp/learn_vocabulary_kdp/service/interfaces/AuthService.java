/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/14 - 11:47 AM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.service.interfaces;

import org.kdp.learn_vocabulary_kdp.model.dto.request.auth.LoginRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.auth.RegisterDto;
import org.kdp.learn_vocabulary_kdp.model.dto.response.user.UserDto;

public interface AuthService {
    UserDto login(LoginRequest request);

    UserDto register(RegisterDto registerDto);
}
