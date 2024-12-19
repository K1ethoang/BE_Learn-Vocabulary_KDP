/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/19 - 15:18 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.entity.Topic;
import org.kdp.learn_vocabulary_kdp.entity.Word;
import org.kdp.learn_vocabulary_kdp.exception.InvalidException;
import org.kdp.learn_vocabulary_kdp.message.WordMessage;
import org.kdp.learn_vocabulary_kdp.model.dto.request.word.WordCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.word.WordUpdateRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.word.WordResponse;
import org.kdp.learn_vocabulary_kdp.model.mapper.WordMapper;
import org.kdp.learn_vocabulary_kdp.repository.WordRepository;
import org.kdp.learn_vocabulary_kdp.service.interfaces.WordService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WordServiceImpl implements WordService {
    WordRepository wordRepository;
    WordMapper wordMapper;

    @Override
    public WordResponse createWord(WordCreationRequest request, Topic topic) {
        if (wordRepository.existsWordByNameAndTopic_Id(request.getName(), topic.getId())) {
            throw new InvalidException(WordMessage.WORD_EXISTS);
        }

        Word word = wordMapper.toWord(request);
        word.setTopic(topic);
        word.setHasRemembered(false);

        wordRepository.save(word);

        return wordMapper.toWordResponse(word);
    }

    @Override
    public WordResponse updateWord(String id, WordUpdateRequest request) {
        return null;
    }

    @Override
    public void deleteWord(String id) {}

    @Override
    public WordResponse getWordByUserId(String user) {
        return null;
    }
}
