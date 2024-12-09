/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/10 - 00:22 AM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.service.interfaces;

public interface JwtService {
    String generateToken(String data);

    boolean isTokenValid(String token);
}
