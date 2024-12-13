/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/13 - 22:53 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.service.interfaces;

import jakarta.servlet.http.HttpServletRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.user.UserDto;

public interface JwtService {
    String generateToken(UserDto userDto);

    boolean isTokenValid(String token);

    String getUidFromToken(String token);

    String getTokenFromRequest(HttpServletRequest request);

    String getUserIdFromRequest(HttpServletRequest request);
}
