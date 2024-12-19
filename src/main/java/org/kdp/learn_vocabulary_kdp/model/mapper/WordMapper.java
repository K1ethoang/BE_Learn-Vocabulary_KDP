/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/19 - 23:39 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.model.mapper;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.entity.Word;
import org.kdp.learn_vocabulary_kdp.model.dto.request.word.WordCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.word.WordUpdateRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.word.WordResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WordMapper {
    ModelMapper modelMapper;

    public Word toWord(WordCreationRequest wordCreationRequest) {
        return modelMapper.map(wordCreationRequest, Word.class);
    }

    public WordResponse toWordResponse(Word word) {
        return modelMapper.map(word, WordResponse.class);
    }

    /**
     * @param wordUpdateRequest nguồn dữ liệu mới
     * @param word              đích dữ liệu cần truyền qua
     */
    public void updateWord(WordUpdateRequest wordUpdateRequest, Word word) {
        modelMapper.map(wordUpdateRequest, word);
    }
}
