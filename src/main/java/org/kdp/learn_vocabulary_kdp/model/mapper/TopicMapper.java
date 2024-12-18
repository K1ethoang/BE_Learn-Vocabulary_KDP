/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/17 - 22:26 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.model.mapper;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.entity.Topic;
import org.kdp.learn_vocabulary_kdp.model.dto.request.topic.TopicCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.topic.TopicUpdateRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.topic.TopicResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TopicMapper {
    ModelMapper modelMapper;

    public Topic toTopic(TopicCreationRequest topicCreationRequest) {
        return modelMapper.map(topicCreationRequest, Topic.class);
    }

    /**
     * @param topicUpdateRequest nguồn dữ liệu mới
     * @param topic              đích dữ liệu cần truyền qua
     */
    public void updateTopic(TopicUpdateRequest topicUpdateRequest, Topic topic) {
        modelMapper.map(topicUpdateRequest, topic);
    }

    public TopicResponse toTopicResponse(Topic topic) {
        return modelMapper.map(topic, TopicResponse.class);
    }
}
