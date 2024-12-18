/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/15 - 16:01 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.model.dto.response.topic;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TopicResponse {
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd")
    Date updatedAt;

    String id;

    String title;

    String description;
}
