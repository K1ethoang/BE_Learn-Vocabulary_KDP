/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/13 - 23:02 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.service.interfaces;

import org.kdp.learn_vocabulary_kdp.model.dto.paging.PageableDto;
import org.kdp.learn_vocabulary_kdp.model.dto.topic.TopicDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TopicService {
    List<TopicDto> getTopics();

    PageableDto getTopicsByUserId(Pageable pageable, String userId);

    TopicDto createTopic(TopicDto topicDto, String userId);
}
