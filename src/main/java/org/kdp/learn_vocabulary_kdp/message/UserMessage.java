/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/20 - 23:03 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.message;

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

    public static final String EMAIL_PASSWORD_INCORRECT = "Email or password is incorrect";
    public static final String EMAIL_EXIST = "Email is already exist";
    public static final String USER_NOT_FOUND = "User not found";
    public static final String USER_BLOCKED = "User is blocked";
}
