/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/26 - 19:02 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.model.dto.response.exam;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.model.dto.response.question.QuestionResponse;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExamResponse {
    String id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date startAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date endAt;

    int totalQuestions;

    int correctCount;

    List<QuestionResponse> questions;
}
