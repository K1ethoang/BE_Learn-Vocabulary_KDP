/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/12 - 14:53 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.service.interfaces;

import org.kdp.learn_vocabulary_kdp.model.dto.auth.LoginDto;
import org.kdp.learn_vocabulary_kdp.model.dto.auth.RegisterDto;
import org.kdp.learn_vocabulary_kdp.model.dto.user.UserDto;

public interface AuthService {
    UserDto login(LoginDto loginDto);

    UserDto register(RegisterDto registerDto);
}
