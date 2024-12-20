/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/20 - 21:23 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.model.dto.request.exam;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.message.GlobalMessage;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExamCreationRequest {
    @Min(value = 1, message = GlobalMessage.MUST_POSITIVE_NUMBER)
    int totalQuestions;

    @Min(value = 1, message = GlobalMessage.MUST_POSITIVE_NUMBER)
    int correctAnswers;

    @NotBlank(message = GlobalMessage.REQUIRED)
    String topicId;
}
