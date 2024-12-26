/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/26 - 18:20 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.message;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExamMessage {
    public static final String EXAM_NOT_FOUND = "Exam is not found";
    public static final String WORD_SIZE_MIN_5 = "Topic must have at least 5 " + "words";
}
