/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/12 - 14:58 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.message;

public class TopicMessage {
    public static final int TITLE_MIN_LENGTH = 5;
    public static final int TITLE_MAX_LENGTH = 20;
    public static final int DESC_MAX_LENGTH = 300;

    //    Required
    public static final String TITLE_REQUIRED = "Title is required";
    public static final String USER_ID_REQUIRED = "User ID is required";

    //    Format
    public static final String TITLE_LENGTH = "Title's length is min " + TITLE_MIN_LENGTH + " and max " + TITLE_MAX_LENGTH + " characters";
    public static final String DESC_LENGTH = "Description's length is max " + DESC_MAX_LENGTH + " characters";

    public static final String TOPIC_EXIST = "Topic is already exist";
}
