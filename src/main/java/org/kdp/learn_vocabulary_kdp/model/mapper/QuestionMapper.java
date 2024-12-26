/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/26 - 15:00 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.model.mapper;

import lombok.AllArgsConstructor;
import org.kdp.learn_vocabulary_kdp.entity.Question;
import org.kdp.learn_vocabulary_kdp.model.dto.response.question.QuestionResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class QuestionMapper {
    ModelMapper modelMapper;

    public QuestionResponse toQuestionResponse(Question question) {
        return modelMapper.map(question, QuestionResponse.class);
    }
}
