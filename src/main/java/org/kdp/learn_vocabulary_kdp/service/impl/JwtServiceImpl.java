/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/14 - 20:34 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.service.impl;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.kdp.learn_vocabulary_kdp.model.dto.response.user.UserResponse;
import org.kdp.learn_vocabulary_kdp.service.interfaces.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JwtServiceImpl implements JwtService {
    private static final String PREFIX_BEARER = "Bearer ";

    @NonFinal
    @Value("${security.jwt.secret-key}")
    String secretKey;

    @NonFinal
    @Value("${security.jwt.expiration-time}")
    long jwtExpirationTime;

    @Override
    public String generateToken(UserResponse userResponse) {
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS512);

        Date now = new Date();
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder().subject(userResponse.getEmail()).issuer("KDP").issueTime(now).expirationTime(Date.from(now.toInstant().plusMillis(jwtExpirationTime))).claim("user_id", userResponse.getId()).claim("scope", userResponse.getRole()).build();
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(jwsHeader, payload);

        try {
            jwsObject.sign(new MACSigner(secretKey.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.error("Cannot create token ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isTokenValid(String token) {
        try {
            JWSVerifier verifier = new MACVerifier(secretKey.getBytes());

            SignedJWT signedJWT = SignedJWT.parse(token);

            boolean verified = signedJWT.verify(verifier);

            Date expirationDate = signedJWT.getJWTClaimsSet().getExpirationTime();

            return verified && expirationDate.after(new Date());
        } catch (ParseException | JOSEException e) {
            return false;
        }
    }
}
