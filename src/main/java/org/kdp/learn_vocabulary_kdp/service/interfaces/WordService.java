/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/19 - 15:18 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.interfaces;

import jakarta.validation.Valid;
import org.kdp.learn_vocabulary_kdp.entity.Topic;
import org.kdp.learn_vocabulary_kdp.model.dto.request.word.WordCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.word.WordUpdateRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.word.WordResponse;
import org.springframework.validation.annotation.Validated;

@Validated
public interface WordService {
    WordResponse createWord(WordCreationRequest request, Topic topic);

    WordResponse updateWord(String id, @Valid WordUpdateRequest request);

    void deleteWord(String id);

    WordResponse getWordByUserId(String user);
}
