/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/13 - 23:22 PM (ICT)
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
import org.kdp.learn_vocabulary_kdp.model.dto.topic.TopicDto;
import org.kdp.learn_vocabulary_kdp.model.mapper.EntityToDto;
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
    EntityToDto entityToDto;

    @Override
    public List<TopicDto> getTopics() {
        return List.of();
    }

    @Override
    public PageableDto getTopicsByUserId(Pageable pageable, String userId) {
        Page<Topic> topicPage = topicRepository.findAllByUserId(userId, pageable);

        List<Topic> topicList = topicPage.getContent();

        List<TopicDto> content = topicList.stream().map(entityToDto::topicDto).toList();

        PageableDto pageableDto = new PageableDto(topicPage);

        pageableDto.setContent(Arrays.asList(content.toArray()));

        return pageableDto;
    }

    @Override
    public TopicDto createTopic(TopicDto topicDto, String userId) throws InvalidException {
        // todo: hiện tại chưa làm thêm words chung với topic
        if (topicRepository.existsTopicByTitle(topicDto.getTitle())) {
            throw new InvalidException(TopicMessage.TOPIC_EXIST);
        }

        User user = User.builder().id(userId).build();

        Topic topic = Topic.builder().title(topicDto.getTitle()).description(topicDto.getDescription()).user(user).build();

        Topic topicCreated = topicRepository.save(topic);
        return entityToDto.topicDto(topicCreated);
    }
}
