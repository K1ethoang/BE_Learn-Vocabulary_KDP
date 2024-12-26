/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/26 - 15:11 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.interfaces;

import java.util.List;

import org.kdp.learn_vocabulary_kdp.model.dto.response.exam.ExamResponse;

public interface ExamService {
    List<ExamResponse> getExamByTopicId(String topicId);

    ExamResponse createExam(String topicId);

    ExamResponse getExam(String examId);
}
