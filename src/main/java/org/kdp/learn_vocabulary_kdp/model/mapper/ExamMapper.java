/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/20 - 20:01 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.model.mapper;

import lombok.AllArgsConstructor;
import org.kdp.learn_vocabulary_kdp.entity.Exam;
import org.kdp.learn_vocabulary_kdp.model.dto.request.exam.ExamCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.exam.ExamResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExamMapper {
    ModelMapper modelMapper;

    public Exam toExam(ExamCreationRequest examCreationRequest) {
        return modelMapper.map(examCreationRequest, Exam.class);
    }

    public ExamResponse toExamResponse(Exam exam) {
        return modelMapper.map(exam, ExamResponse.class);
    }
}
