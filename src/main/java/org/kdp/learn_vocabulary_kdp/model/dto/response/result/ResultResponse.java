/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/26 - 15:02 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.model.dto.response.result;

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
public class ResultResponse {
    String id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date createdAt;

    int correctCount;

    String details;
}
