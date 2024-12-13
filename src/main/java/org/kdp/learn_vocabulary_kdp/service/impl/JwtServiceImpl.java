/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/13 - 22:54 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.service.impl;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.user.UserDto;
import org.kdp.learn_vocabulary_kdp.service.interfaces.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {
    private final String PREFIX_BEARER = "Bearer ";

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Value("${security.jwt.expiration-time}")
    private Long jwtExpirationTime;

    @Override
    public String generateToken(UserDto userDto) {
        SecretKey key = getSecretKey();


        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + jwtExpirationTime);

        return Jwts.builder().subject(userDto.getEmail()).claim("uid", userDto.getId()).issuedAt(new Date()).expiration(expireDate).signWith(key).compact();
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

    @Override
    public String getUidFromToken(String token) {
        return Jwts.parser().verifyWith(getSecretKey()).build().parseSignedClaims(token).getPayload().get("uid").toString();
    }

    @Override
    public String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader = request.getHeader("Authorization");
        String token = null;

        if (authHeader != null && authHeader.startsWith(PREFIX_BEARER)) {
            token = authHeader.substring(PREFIX_BEARER.length());
        }

        return token;
    }

    @Override
    public String getUserIdFromRequest(HttpServletRequest request) {
        return getUidFromToken(getTokenFromRequest(request));
    }

    public SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }
}
