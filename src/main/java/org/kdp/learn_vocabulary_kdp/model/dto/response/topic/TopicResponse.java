/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/14 - 19:09 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.model.dto.response.topic;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.entity.TopicWord;

import java.util.Date;
import java.util.List;

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

    @JsonProperty("word_list")
    private List<TopicWord> topicWords;
}
