package org.kdp.learn_vocabulary_kdp.util.validator;

import org.kdp.learn_vocabulary_kdp.exception.NotNullException;
import org.kdp.learn_vocabulary_kdp.message.WordMessage;
import org.kdp.learn_vocabulary_kdp.model.dto.word.WordDto;

public class WordValidator {
    public static void notNullWord(String word) throws NotNullException {
        if (word == null || word.trim().isEmpty())
            throw new NotNullException(WordMessage.WORD_NOT_NULL);
    }

    public static void validateWordDto(WordDto wordDto) {
        notNullWord(wordDto.getWord());
    }
}
