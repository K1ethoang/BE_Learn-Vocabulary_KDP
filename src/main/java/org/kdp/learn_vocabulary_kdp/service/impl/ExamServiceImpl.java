/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/20 - 21:17 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.Util.ContextHolderUtil;
import org.kdp.learn_vocabulary_kdp.entity.Exam;
import org.kdp.learn_vocabulary_kdp.entity.Topic;
import org.kdp.learn_vocabulary_kdp.exception.InvalidException;
import org.kdp.learn_vocabulary_kdp.exception.NotFoundException;
import org.kdp.learn_vocabulary_kdp.message.ExamMessage;
import org.kdp.learn_vocabulary_kdp.model.dto.request.exam.ExamCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.exam.ExamResponse;
import org.kdp.learn_vocabulary_kdp.model.dto.response.topic.TopicResponse;
import org.kdp.learn_vocabulary_kdp.model.mapper.ExamMapper;
import org.kdp.learn_vocabulary_kdp.repository.ExamRepository;
import org.kdp.learn_vocabulary_kdp.service.interfaces.ExamService;
import org.kdp.learn_vocabulary_kdp.service.interfaces.TopicService;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExamServiceImpl implements ExamService {
    ExamMapper examMapper;
    ExamRepository examRepository;
    TopicService topicService;
    ContextHolderUtil contextHolderUtil;

    @Override
    public ExamResponse createExam(ExamCreationRequest request) throws InvalidException {
        if (request.getCorrectAnswers() > request.getTotalQuestions())
            throw new InvalidException(ExamMessage.CORRECT_SMALLER_OR_EQUAL_THAN_TOTAL_NUMBER);

        // Kiểm tra xem topic này có thuộc về user không
        TopicResponse topicResponse = topicService.getTopicDto(request.getTopicId());

        Exam exam = examMapper.toExam(request);
        exam.setTopic(Topic.builder().id(topicResponse.getId()).build());

        examRepository.save(exam);
        return examMapper.toExamResponse(exam);
    }

    @Override
    public ExamResponse getExam(String examId) throws AccessDeniedException, NotFoundException {
        Exam exam =
                examRepository.findById(examId).orElseThrow(() -> new NotFoundException(ExamMessage.EXAM_NOT_FOUND));

        // Kiểm tra exam này có thuộc về user không
        String userId = contextHolderUtil.getUserIdFromContext();

        if (!userId.equals(exam.getTopic().getUser().getId())) {
            throw new AccessDeniedException("");
        }

        return examMapper.toExamResponse(exam);
    }

    @Override
    public void deleteExam(String examId) throws NotFoundException {
        // Kiểm tra có tồn tại exam này không
        ExamResponse examResponse = getExam(examId);

        examRepository.deleteById(examId);
    }
}
