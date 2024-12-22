/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/22 - 23:45 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.message;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalMessage {
    public static final String REQUIRED = "Required";
    public static final String SUCCESSFULLY = "Successfully";
    public static final String AUTHENTICATED = "Unauthenticated";
    public static final String MUST_POSITIVE_NUMBER = "Must be positive number";
    public static final String EMAIL_SENT = "Email is sent";
}
