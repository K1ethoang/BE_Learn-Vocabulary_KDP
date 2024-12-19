/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/20 - 00:47 AM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.impl;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.kdp.learn_vocabulary_kdp.Util.ContextHolderUtil;
import org.kdp.learn_vocabulary_kdp.entity.Topic;
import org.kdp.learn_vocabulary_kdp.entity.Type;
import org.kdp.learn_vocabulary_kdp.entity.User;
import org.kdp.learn_vocabulary_kdp.entity.Word;
import org.kdp.learn_vocabulary_kdp.exception.InvalidException;
import org.kdp.learn_vocabulary_kdp.exception.NotFoundException;
import org.kdp.learn_vocabulary_kdp.message.TopicMessage;
import org.kdp.learn_vocabulary_kdp.message.WordMessage;
import org.kdp.learn_vocabulary_kdp.model.dto.paging.PageableDto;
import org.kdp.learn_vocabulary_kdp.model.dto.request.topic.TopicCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.topic.TopicUpdateRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.word.WordCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.word.WordUpdateRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.topic.TopicResponse;
import org.kdp.learn_vocabulary_kdp.model.dto.response.word.WordResponse;
import org.kdp.learn_vocabulary_kdp.model.mapper.TopicMapper;
import org.kdp.learn_vocabulary_kdp.model.mapper.WordMapper;
import org.kdp.learn_vocabulary_kdp.repository.TopicRepository;
import org.kdp.learn_vocabulary_kdp.repository.TypeRepository;
import org.kdp.learn_vocabulary_kdp.repository.WordRepository;
import org.kdp.learn_vocabulary_kdp.service.interfaces.TopicService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TopicServiceImpl implements TopicService {
    ContextHolderUtil contextHolderUtil;
    WordRepository wordRepository;
    TopicRepository topicRepository;
    TopicMapper topicMapper;
    WordMapper wordMapper;
    TypeRepository typeRepository;

    public Topic getTopic(String topicId) {
        Topic topic = topicRepository
                .findById(topicId)
                .orElseThrow(() -> new NotFoundException(TopicMessage.TOPIC_NOT_FOUND));

        String userId = contextHolderUtil.getUserIdFromContext();
        // Check topic belong to this user
        if (!userId.equals(topic.getUser().getId())) {
            throw new AccessDeniedException("");
        }

        return topic;
    }

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

        List<TopicResponse> content =
                topicList.stream().map(topicMapper::toTopicResponse).toList();

        PageableDto pageableDto = new PageableDto(topicPage);

        pageableDto.setContent(Arrays.asList(content.toArray()));

        return pageableDto;
    }

    /**
     * @hidden Auto get userId from Context Holder to checks
     */
    @Override
    public TopicResponse createTopic(TopicCreationRequest topicCreationRequest)
            throws InvalidException, NotFoundException {
        String userId = contextHolderUtil.getUserIdFromContext();

        // Kiểm tra đã có topic trùng với title và thuộc về user này chưa
        if (topicRepository.existsTopicByTitleAndUser_Id(topicCreationRequest.getTitle(), userId)) {
            throw new InvalidException(TopicMessage.TOPIC_EXIST);
        }

        Topic topic = topicMapper.toTopic(topicCreationRequest);
        topic.setUser(User.builder().id(userId).build());

        topicRepository.save(topic);
        return topicMapper.toTopicResponse(topic);
    }

    @Override
    public TopicResponse updateTopic(@Valid TopicUpdateRequest topicUpdateRequest, String topicId)
            throws NotFoundException, InvalidException {
        Topic topic = getTopic(topicId);

        // Kiểm tra đã có topic trùng với title và thuộc về user này chưa
        if (topicRepository.existsTopicByTitleAndUser_IdAndIdNot(
                topicUpdateRequest.getTitle(), topic.getUser().getId(), topicId)) {
            throw new InvalidException(TopicMessage.TOPIC_EXIST);
        }

        topicMapper.updateTopic(topicUpdateRequest, topic);

        topicRepository.save(topic);
        return topicMapper.toTopicResponse(topic);
    }

    @Override
    public WordResponse addWord(String topicId, WordCreationRequest request)
            throws InvalidException, NotFoundException {
        Topic topic = getTopic(topicId);

        // Kiểm tra đã có word với Name này chưa
        if (wordRepository.existsWordByNameAndTopic_Id(request.getName(), topicId)) {
            throw new InvalidException(WordMessage.WORD_EXISTS);
        }

        Word word = wordMapper.toWord(request);
        word.setTopic(topic);
        word.setHasRemembered(false);

        // Tìm ds type theo Id
        List<Type> types = typeRepository.findAllById(request.getTypeIds());

        word.setTypes(types);

        wordRepository.save(word);

        return wordMapper.toWordResponse(word);
    }

    @Override
    public WordResponse updateWord(String topicId, String wordId, @Valid WordUpdateRequest request) {
        Topic topic = getTopic(topicId);

        Word word = topic.getWords().stream()
                .filter(w -> w.getId().equals(wordId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException(WordMessage.WORD_NOT_FOUND));

        // Kiểm tra đã có word với Name này chưa
        if (wordRepository.existsWordByNameAndTopic_IdAndIdNot(request.getName(), topicId, wordId)) {
            throw new InvalidException(WordMessage.WORD_EXISTS);
        }

        // Cập nhật dữ liệu cần chỉnh sửa
        wordMapper.updateWord(request, word);

        // Cập nhật các loại từ (types) nếu có thay đổi
        if (request.getTypeIds() != null) {
            // Tìm ds type theo Id
            List<Type> newTypes = typeRepository.findAllById(request.getTypeIds());

            word.setTypes(newTypes);
        }

        wordRepository.save(word);

        return wordMapper.toWordResponse(word);
    }

    @Override
    public void deleteWord(String topicId, String wordId) throws NotFoundException {
        Topic topic = getTopic(topicId);

        Word word = topic.getWords().stream()
                .filter(w -> w.getId().equals(wordId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException(WordMessage.WORD_NOT_FOUND));

        wordRepository.delete(word);
    }

    @Override
    public List<WordResponse> getWords(String topicId) {
        Topic topic = getTopic(topicId);

        return topic.getWords().stream().map(wordMapper::toWordResponse).toList();
    }

    @Override
    public TopicResponse getTopicDto(String topicId) {
        return topicMapper.toTopicResponse(getTopic(topicId));
    }

    @Override
    public void deleteTopic(String topicId) {
        Topic topic = getTopic(topicId);

        wordRepository.deleteAll(topic.getWords());

        topicRepository.delete(topic);
    }
}
