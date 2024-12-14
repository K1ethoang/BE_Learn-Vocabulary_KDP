/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/14 - 11:38 AM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kdp.learn_vocabulary_kdp.entity.Topic;
import org.kdp.learn_vocabulary_kdp.entity.User;
import org.kdp.learn_vocabulary_kdp.exception.InvalidException;
import org.kdp.learn_vocabulary_kdp.message.TopicMessage;
import org.kdp.learn_vocabulary_kdp.model.dto.paging.PageableDto;
import org.kdp.learn_vocabulary_kdp.model.dto.request.topic.TopicCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.topic.TopicResponse;
import org.kdp.learn_vocabulary_kdp.model.mapper.TopicMapper;
import org.kdp.learn_vocabulary_kdp.repository.TopicRepository;
import org.kdp.learn_vocabulary_kdp.service.interfaces.TopicService;
import org.kdp.learn_vocabulary_kdp.service.interfaces.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
@Transactional
public class TopicServiceImpl implements TopicService {
    UserService userService;
    TopicRepository topicRepository;
    TopicMapper topicMapper;

    @Override
    public List<TopicResponse> getTopics() {
        return List.of();
    }

    @Override
    public PageableDto getTopicsByUserId(Pageable pageable, String userId) {
        Page<Topic> topicPage = topicRepository.findAllByUserId(userId, pageable);

        List<Topic> topicList = topicPage.getContent();

        List<TopicResponse> content = topicList.stream().map(topicMapper::toDto).toList();

        PageableDto pageableDto = new PageableDto(topicPage);

        pageableDto.setContent(Arrays.asList(content.toArray()));

        return pageableDto;
    }

    @Override
    public TopicResponse createTopic(TopicCreationRequest topicCreationRequest, String userId) throws InvalidException {
        // todo: hiện tại chưa làm thêm words chung với topic
        if (topicRepository.existsTopicByTitle(topicCreationRequest.getTitle())) {
            throw new InvalidException(TopicMessage.TOPIC_EXIST);
        }

        Topic topic = topicMapper.toEntity(topicCreationRequest);
        topic.setUser(User.builder().id(userId).build());

        Topic topicCreated = topicRepository.save(topic);
        return topicMapper.toDto(topicCreated);
    }
}
