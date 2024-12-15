/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/15 - 16:39 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.kdp.learn_vocabulary_kdp.Util.ContextHolderUtil;
import org.kdp.learn_vocabulary_kdp.entity.Topic;
import org.kdp.learn_vocabulary_kdp.entity.User;
import org.kdp.learn_vocabulary_kdp.exception.InvalidException;
import org.kdp.learn_vocabulary_kdp.exception.NotFoundException;
import org.kdp.learn_vocabulary_kdp.message.TopicMessage;
import org.kdp.learn_vocabulary_kdp.model.dto.paging.PageableDto;
import org.kdp.learn_vocabulary_kdp.model.dto.request.topic.TopicCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.topic.TopicUpdateRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.topic.TopicResponse;
import org.kdp.learn_vocabulary_kdp.model.mapper.TopicMapper;
import org.kdp.learn_vocabulary_kdp.model.mapper.UserMapper;
import org.kdp.learn_vocabulary_kdp.repository.TopicRepository;
import org.kdp.learn_vocabulary_kdp.repository.UserRepository;
import org.kdp.learn_vocabulary_kdp.service.interfaces.TopicService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TopicServiceImpl implements TopicService {
    ContextHolderUtil contextHolderUtil;
    UserMapper userMapper;
    UserRepository userRepository;
    TopicRepository topicRepository;
    TopicMapper topicMapper;

    @Override
    public List<TopicResponse> getTopics() {
        return List.of();
    }

    /**
     * @hidden Auto get userId from Context Holder to checks
     */
    @Override
    public PageableDto getTopicsByUserId(Pageable pageable) {
        String userId = contextHolderUtil.getUserIdFromContext();
        Page<Topic> topicPage = topicRepository.findAllByUserId(userId, pageable);

        List<Topic> topicList = topicPage.getContent();

        List<TopicResponse> content = topicList.stream().map(topicMapper::toTopicResponse).toList();

        PageableDto pageableDto = new PageableDto(topicPage);

        pageableDto.setContent(Arrays.asList(content.toArray()));

        return pageableDto;
    }

    /**
     * @hidden Auto get userId from Context Holder to checks
     */
    @Override
    public TopicResponse createTopic(TopicCreationRequest topicCreationRequest) throws InvalidException, NotFoundException {
        String userId = contextHolderUtil.getUserIdFromContext();

        if (topicRepository.existsTopicByTitleAndUser_Id(topicCreationRequest.getTitle(), userId)) {
            throw new InvalidException(TopicMessage.TOPIC_EXIST);
        }

        Optional<User> user = userRepository.findById(userId);
        Topic topic = topicMapper.toTopic(topicCreationRequest);

        user.ifPresent(topic::setUser);

        Topic topicCreated = topicRepository.save(topic);
        return topicMapper.toTopicResponse(topicCreated);
    }

    /**
     * @hidden Auto get userId from Context Holder to checks
     */
    @Override
    public TopicResponse updateTopic(TopicUpdateRequest topicUpdateRequest, String topicId) throws NotFoundException {
        Topic topic = topicRepository.findById(topicId).orElseThrow(() -> new NotFoundException(TopicMessage.TOPIC_NOT_FOUND));

        String userId = contextHolderUtil.getUserIdFromContext();
        // Check topic belong to this user
        if (!userId.equals(topic.getUser().getId())) {
            throw new AccessDeniedException("");
        }

        // TODO: check data not empty
        topicMapper.updateTopic(topicUpdateRequest, topic);

        topic = topicRepository.save(topic);
        return topicMapper.toTopicResponse(topic);
    }
}
