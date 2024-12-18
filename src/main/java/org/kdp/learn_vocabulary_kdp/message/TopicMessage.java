/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/18 - 00:12 AM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.message;

public class TopicMessage {
    public static final int TITLE_MIN_LENGTH = 3;
    public static final int TITLE_MAX_LENGTH = 100;
    public static final int DESC_MAX_LENGTH = 300;

    public static final String TITLE_LENGTH =
            "Length: min " + TITLE_MIN_LENGTH + " and max " + TITLE_MAX_LENGTH + " characters";
    public static final String DESC_LENGTH = "Length: max " + DESC_MAX_LENGTH + " characters";

    public static final String TOPIC_EXIST = "Topic is already exist";
    public static final String TOPIC_NOT_FOUND = "Topic is not found";
}
