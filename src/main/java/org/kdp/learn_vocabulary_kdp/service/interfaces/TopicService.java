/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/14 - 20:37 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.service.interfaces;

import org.kdp.learn_vocabulary_kdp.model.dto.paging.PageableDto;
import org.kdp.learn_vocabulary_kdp.model.dto.request.topic.TopicCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.topic.TopicResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TopicService {
    List<TopicResponse> getTopics();

    PageableDto getTopicsByUserId(Pageable pageable);

    TopicResponse createTopic(TopicCreationRequest topicCreationRequest);
}
