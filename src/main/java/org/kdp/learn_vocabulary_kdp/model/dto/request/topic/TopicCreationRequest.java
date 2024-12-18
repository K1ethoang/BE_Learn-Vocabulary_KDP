/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/18 - 00:11 AM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.model.dto.request.topic;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.jackson.TrimDeserializer;
import org.kdp.learn_vocabulary_kdp.message.GlobalMessage;
import org.kdp.learn_vocabulary_kdp.message.TopicMessage;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TopicCreationRequest {
    @NotBlank(message = GlobalMessage.REQUIRED)
    @Size(min = TopicMessage.TITLE_MIN_LENGTH, max = TopicMessage.TITLE_MAX_LENGTH, message = TopicMessage.TITLE_LENGTH)
    @JsonDeserialize(using = TrimDeserializer.class)
    String title;

    @Size(max = TopicMessage.DESC_MAX_LENGTH, message = TopicMessage.DESC_LENGTH)
    @JsonDeserialize(using = TrimDeserializer.class)
    String description;
}
