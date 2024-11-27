package org.kdp.learn_vocabulary_kdp.model.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.kdp.learn_vocabulary_kdp.entity.Word;
import org.kdp.learn_vocabulary_kdp.model.DTO.word.WordDto;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@Data
public class EntityToDto {
    private static ModelMapper mapper;

    public static WordDto wordDto(Word word) {
        return mapper.map(word, WordDto.class);
    }
}
