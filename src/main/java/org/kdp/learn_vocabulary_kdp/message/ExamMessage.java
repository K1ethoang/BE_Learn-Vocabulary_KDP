/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/20 - 20:24 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.message;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExamMessage {
    public static final String EXAM_NOT_FOUND = "Exam is not found";
    public static final String CORRECT_SMALLER_OR_EQUAL_THAN_TOTAL_NUMBER =
            "Correct " + "answer must be smaller or equal than total number";
}
