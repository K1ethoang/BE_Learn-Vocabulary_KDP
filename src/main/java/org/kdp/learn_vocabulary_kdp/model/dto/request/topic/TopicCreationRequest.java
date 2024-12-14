/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/14 - 20:44 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.model.dto.request.topic;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.entity.TopicWord;
import org.kdp.learn_vocabulary_kdp.jackson.TrimDeserializer;
import org.kdp.learn_vocabulary_kdp.message.TopicMessage;
import org.kdp.learn_vocabulary_kdp.message.UserMessage;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TopicCreationRequest {
    @NotBlank(message = TopicMessage.TITLE_REQUIRED)
    @Size(min = TopicMessage.TITLE_MIN_LENGTH, max = TopicMessage.TITLE_MAX_LENGTH, message = TopicMessage.TITLE_LENGTH)
    @JsonDeserialize(using = TrimDeserializer.class)
    String title;

    @Size(max = TopicMessage.DESC_MAX_LENGTH, message = TopicMessage.DESC_LENGTH)
    @JsonDeserialize(using = TrimDeserializer.class)
    String description;

    @NotBlank(message = UserMessage.USER_ID_REQUIRED)
    String userId;

    @JsonProperty("word_list")
    List<TopicWord> topicWords;

}
