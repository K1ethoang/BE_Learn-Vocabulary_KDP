/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/26 - 22:50 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.model.dto.request.exam;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.message.GlobalMessage;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExamSubmitRequest {
    @NotNull(message = GlobalMessage.REQUIRED)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    Date startAt;

    @NotNull(message = GlobalMessage.REQUIRED)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    Date endAt;

    @NotEmpty(message = GlobalMessage.REQUIRED)
    List<Answer> results;
}
