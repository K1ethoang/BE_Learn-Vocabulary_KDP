/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/08 - 01:31 AM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.impl;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import org.kdp.learn_vocabulary_kdp.entity.Word;
import org.kdp.learn_vocabulary_kdp.exception.NotFoundException;
import org.kdp.learn_vocabulary_kdp.message.WordMessage;
import org.kdp.learn_vocabulary_kdp.model.dto.paging.PageableDto;
import org.kdp.learn_vocabulary_kdp.model.dto.word.WordDto;
import org.kdp.learn_vocabulary_kdp.model.mapper.EntityToDto;
import org.kdp.learn_vocabulary_kdp.repository.WordRepository;
import org.kdp.learn_vocabulary_kdp.service.interfaces.WordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;
    EntityToDto entityToDto;

    @Override
    public PageableDto getAllWords(Pageable pageable) {
        Page<Word> wordPage = wordRepository.findAll(pageable);

        List<Word> wordList = wordPage.getContent();

        List<WordDto> content = wordList.stream().map(entityToDto::wordDto).toList();

        PageableDto pageableDto = new PageableDto(wordPage);

        pageableDto.setContent(Arrays.asList(content.toArray()));

        return pageableDto;
    }

    @Override
    public WordDto getWordByUserId(String id) throws NotFoundException {
        Word wordFromDb = wordRepository.findById(id).orElseThrow(() -> new NotFoundException(WordMessage.NOT_FOUND));

        return entityToDto.wordDto(wordFromDb);
    }

    @Override
    public WordDto createWord(WordDto wordDto) {
        // validate first

        return null;
    }

    @Override
    public WordDto updateWord(String id, WordDto wordDto) {
        return null;
    }

    @Override
    public void deleteWord(String id) {}
}
