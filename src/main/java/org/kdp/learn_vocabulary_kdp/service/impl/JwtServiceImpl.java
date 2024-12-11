/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/10 - 00:38 AM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.service.impl;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.kdp.learn_vocabulary_kdp.service.interfaces.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class JwtServiceImpl implements JwtService {
    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Override
    public String generateToken(String data) {
        SecretKey key = getSecretKey();

        return Jwts.builder().subject(data).signWith(key).compact();
    }

    @Override
    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().verifyWith(getSecretKey()).build().parseSignedClaims(token);
            return true;
        } catch (JwtException ex) {
            return false;
        }
    }

    public SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }
}
