package org.kdp.learn_vocabulary_kdp.service.impl;

import lombok.AllArgsConstructor;
import org.kdp.learn_vocabulary_kdp.entity.Word;
import org.kdp.learn_vocabulary_kdp.exception.NotFoundException;
import org.kdp.learn_vocabulary_kdp.message.WordMessage;
import org.kdp.learn_vocabulary_kdp.model.DTO.paging.PageableDto;
import org.kdp.learn_vocabulary_kdp.model.DTO.word.WordDto;
import org.kdp.learn_vocabulary_kdp.model.mapper.EntityToDto;
import org.kdp.learn_vocabulary_kdp.repository.WordRepository;
import org.kdp.learn_vocabulary_kdp.service.interfaces.WordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;

    @Override
    public PageableDto getAllWords(Pageable pageable) {
        Page<Word> wordPage = wordRepository.findAll(pageable);

        List<Word> wordList = wordPage.getContent();

        List<WordDto> content = wordList.stream().map(EntityToDto::wordDto).toList();

        PageableDto pageableDto = new PageableDto(wordPage);

        pageableDto.setContent(Arrays.asList(content.toArray()));

        return pageableDto;
    }

    @Override
    public WordDto getWordById(String id) throws NotFoundException {
        Word wordFromDb = wordRepository.findById(id).orElseThrow(() -> new NotFoundException(WordMessage.NOT_FOUND));

        return EntityToDto.wordDto(wordFromDb);
    }

    @Override
    public WordDto createWord(WordDto wordDto) {
        return null;
    }

    @Override
    public WordDto updateWord(String id, WordDto wordDto) {
        return null;
    }

    @Override
    public void deleteWord(String id) {
    }
}
