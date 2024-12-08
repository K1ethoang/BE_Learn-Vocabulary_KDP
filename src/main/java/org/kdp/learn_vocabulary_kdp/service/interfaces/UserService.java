/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/08 - 01:21 AM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.service.interfaces;

import org.kdp.learn_vocabulary_kdp.model.dto.user.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();
}
