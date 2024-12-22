/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/23 - 00:14 AM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.message;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMessage {
    public static final int FULLNAME_MIN_LENGTH = 5;
    public static final int FULLNAME_MAX_LENGTH = 40;
    public static final int PASSWORD_MIN_LENGTH = 8;
    public static final int PASSWORD_MAX_LENGTH = 20;

    //    Format
    public static final String FULLNAME_FORMAT =
            "Full_name's length is min " + FULLNAME_MIN_LENGTH + " and max " + FULLNAME_MAX_LENGTH + " characters";
    public static final String PASSWORD_FORMAT =
            "Password's length is min " + PASSWORD_MIN_LENGTH + " and max " + PASSWORD_MAX_LENGTH + " characters";
    public static final String EMAIL_FORMAT = "Email is not right format";
    public static final String PASSWORD_FORMAT_MIN =
            "Password's length is at least " + PASSWORD_MIN_LENGTH + " characters";

    public static final String PASSWORD_INCORRECT = "Password is incorrect";
    public static final String EMAIL_EXIST = "Email is already exist";
    public static final String USER_NOT_FOUND = "User not found";
    public static final String USER_BLOCKED = "User is blocked";

    public static final String TOKEN_INVALID = "Token is invalid";
    public static final String TOKEN_EXPIRED = "Token has expired";
    public static final String VERIFY_EMAIL = "You must verify your email " + "address";
    public static final String ACCOUNT_ACTIVATED = "Account is activated";
    public static final String EMAIL_INVALID = "Email is invalid";
}
