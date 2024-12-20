/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/20 - 20:39 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.model.dto.response.exam;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExamResponse {
    String id;
    int totalQuestions;
    int correctAnswers;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date completedAt;
}
