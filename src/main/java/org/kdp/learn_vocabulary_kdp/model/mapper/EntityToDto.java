/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/11 - 23:48 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.model.mapper;

import lombok.AllArgsConstructor;
import org.kdp.learn_vocabulary_kdp.entity.Topic;
import org.kdp.learn_vocabulary_kdp.entity.User;
import org.kdp.learn_vocabulary_kdp.entity.Word;
import org.kdp.learn_vocabulary_kdp.model.dto.topic.TopicDto;
import org.kdp.learn_vocabulary_kdp.model.dto.user.UserDto;
import org.kdp.learn_vocabulary_kdp.model.dto.word.WordDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class EntityToDto {
    private final ModelMapper mapper;

    public WordDto wordDto(Word word) {
        return mapper.map(word, WordDto.class);
    }

    public UserDto userDto(User user) {
        return mapper.map(user, UserDto.class);
    }

    public TopicDto topicDto(Topic topic) {
        return mapper.map(topic, TopicDto.class);
    }
}
