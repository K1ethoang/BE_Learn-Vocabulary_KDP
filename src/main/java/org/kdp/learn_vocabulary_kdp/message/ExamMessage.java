/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/26 - 22:55 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.message;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExamMessage {
    public static final String EXAM_NOT_FOUND = "Exam is not found";
    public static final String WORD_SIZE_MIN_5 = "Topic must have at least 5 words";
    public static final String RESULTS_MISS = "The number of results is not enough";
    public static final String EXAM_SUBMITTED = "Exam is submitted";
    public static final String END_MUST_GREATER_START = "EndAt must be " + "greater than startAt";
}
