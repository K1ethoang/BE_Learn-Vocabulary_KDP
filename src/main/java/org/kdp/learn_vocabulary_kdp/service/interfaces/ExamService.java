/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/20 - 21:18 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.interfaces;

import org.kdp.learn_vocabulary_kdp.model.dto.request.exam.ExamCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.exam.ExamResponse;

public interface ExamService {
    ExamResponse createExam(ExamCreationRequest request);

    ExamResponse getExam(String examId);

    void deleteExam(String examId);
}
