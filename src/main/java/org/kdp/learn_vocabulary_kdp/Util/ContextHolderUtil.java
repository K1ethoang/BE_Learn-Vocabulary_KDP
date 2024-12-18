/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/15 - 15:51 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.Util;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@NoArgsConstructor
public class ContextHolderUtil {
    private Authentication getAuthentication() {
        var context = SecurityContextHolder.getContext();
        if (context == null || context.getAuthentication() == null) {
            log.error("No authentication context found.");
            return null;
        }
        return context.getAuthentication();
    }

    public String getNameFromContext() {
        var authentication = getAuthentication();
        return authentication != null ? authentication.getName() : null;
    }

    public String getUserIdFromContext() {
        var authentication = getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof Jwt jwt) {
            return jwt.getClaimAsString("user_id");
        }
        return null;
    }
}
