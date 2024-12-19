/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/20 - 00:40 AM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.interfaces;

import java.util.List;

import jakarta.validation.Valid;
import org.kdp.learn_vocabulary_kdp.model.dto.paging.PageableDto;
import org.kdp.learn_vocabulary_kdp.model.dto.request.topic.TopicCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.topic.TopicUpdateRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.word.WordCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.word.WordUpdateRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.topic.TopicResponse;
import org.kdp.learn_vocabulary_kdp.model.dto.response.word.WordResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

@Validated
public interface TopicService {
    List<TopicResponse> getTopics();

    PageableDto getTopicsByUserId(Pageable pageable);

    TopicResponse createTopic(TopicCreationRequest topicCreationRequest);

    TopicResponse updateTopic(@Valid TopicUpdateRequest topicUpdateRequest, String topicId);

    WordResponse addWord(String topicId, @Valid WordCreationRequest request);

    WordResponse updateWord(String topicId, String wordId, @Valid WordUpdateRequest request);

    void deleteWord(String topicId, String wordId);

    List<WordResponse> getWords(String topicId);

    TopicResponse getTopicDto(String topicId);

    void deleteTopic(String topicId);
}
