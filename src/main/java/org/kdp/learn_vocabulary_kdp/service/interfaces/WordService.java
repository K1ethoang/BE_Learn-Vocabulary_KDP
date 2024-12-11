package org.kdp.learn_vocabulary_kdp.service.interfaces;

import org.kdp.learn_vocabulary_kdp.model.dto.paging.PageableDto;
import org.kdp.learn_vocabulary_kdp.model.dto.word.WordDto;
import org.springframework.data.domain.Pageable;

public interface WordService {
    PageableDto getAllWords(Pageable pageable);

    WordDto createWord(WordDto wordDto);

    WordDto updateWord(String id, WordDto wordDto);

    void deleteWord(String id);

    WordDto getWordByUserId(String user);
}
