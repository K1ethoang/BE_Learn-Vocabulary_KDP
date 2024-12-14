/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/14 - 11:32 AM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.service.interfaces;

import org.kdp.learn_vocabulary_kdp.model.dto.paging.PageableDto;
import org.kdp.learn_vocabulary_kdp.model.dto.request.topic.TopicCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.topic.TopicResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TopicService {
    List<TopicResponse> getTopics();

    PageableDto getTopicsByUserId(Pageable pageable, String userId);

    TopicResponse createTopic(TopicCreationRequest topicCreationRequest, String userId);
}
