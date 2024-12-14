/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/14 - 11:37 AM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.model.mapper;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.entity.Topic;
import org.kdp.learn_vocabulary_kdp.model.dto.request.topic.TopicCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.topic.TopicResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TopicMapper {
    ModelMapper modelMapper;

    public Topic toEntity(TopicCreationRequest topicCreationRequest) {
        return modelMapper.map(topicCreationRequest, Topic.class);
    }

    public TopicResponse toDto(Topic topic) {
        return modelMapper.map(topic, TopicResponse.class);
    }
}
