/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/14 - 20:10 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ERole {
    ADMIN("ADMIN"),
    USER("USER");

    private final String name;
}
