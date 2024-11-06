package org.kdp.learn_vocabulary_kdp.model.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.kdp.learn_vocabulary_kdp.entity.Word;
import org.kdp.learn_vocabulary_kdp.model.DTO.word.WordDto;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@Data
public class DtoToEntity {
    private static ModelMapper mapper;

    public static Word Word(WordDto wordDto) {
        return mapper.map(wordDto, Word.class);
    }
}
