/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/26 - 22:43 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.interfaces;

import java.util.List;

import org.kdp.learn_vocabulary_kdp.model.dto.request.exam.ExamSubmitRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.exam.ExamResponse;

public interface ExamService {
    List<ExamResponse> getExamByTopicId(String topicId);

    ExamResponse createExam(String topicId);

    ExamResponse getExamDto(String examId);

    ExamResponse submitExam(ExamSubmitRequest request, String examId);
}
