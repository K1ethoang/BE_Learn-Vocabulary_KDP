/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/13 - 23:44 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.model.dto.topic;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kdp.learn_vocabulary_kdp.entity.TopicWord;
import org.kdp.learn_vocabulary_kdp.jackson.TrimDeserializer;
import org.kdp.learn_vocabulary_kdp.message.TopicMessage;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * DTO for {@link org.kdp.learn_vocabulary_kdp.entity.Topic}
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TopicDto implements Serializable {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    @NotBlank(message = TopicMessage.TITLE_REQUIRED)
    @Size(min = TopicMessage.TITLE_MIN_LENGTH, max = TopicMessage.TITLE_MAX_LENGTH, message = TopicMessage.TITLE_LENGTH)
    @JsonDeserialize(using = TrimDeserializer.class)
    private String title;

    @Size(max = TopicMessage.DESC_MAX_LENGTH, message = TopicMessage.DESC_LENGTH)
    @JsonDeserialize(using = TrimDeserializer.class)
    private String description;

    @JsonProperty("word_list")
    private List<TopicWord> topicWords;
}
