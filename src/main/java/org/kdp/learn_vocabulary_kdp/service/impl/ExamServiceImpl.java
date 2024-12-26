/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/26 - 18:20 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.kdp.learn_vocabulary_kdp.Util.ContextHolderUtil;
import org.kdp.learn_vocabulary_kdp.entity.Exam;
import org.kdp.learn_vocabulary_kdp.entity.Topic;
import org.kdp.learn_vocabulary_kdp.exception.InvalidException;
import org.kdp.learn_vocabulary_kdp.exception.NotFoundException;
import org.kdp.learn_vocabulary_kdp.message.ExamMessage;
import org.kdp.learn_vocabulary_kdp.model.dto.response.exam.ExamResponse;
import org.kdp.learn_vocabulary_kdp.model.dto.response.question.QuestionResponse;
import org.kdp.learn_vocabulary_kdp.model.dto.response.word.WordResponse;
import org.kdp.learn_vocabulary_kdp.model.mapper.ExamMapper;
import org.kdp.learn_vocabulary_kdp.repository.ExamRepository;
import org.kdp.learn_vocabulary_kdp.service.interfaces.ExamService;
import org.kdp.learn_vocabulary_kdp.service.interfaces.QuestionService;
import org.kdp.learn_vocabulary_kdp.service.interfaces.TopicService;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExamServiceImpl implements ExamService {
    ExamMapper examMapper;
    ExamRepository examRepository;
    TopicService topicService;
    ContextHolderUtil contextHolderUtil;
    QuestionService questionService;

    int MIN_WORD_IN_TOPIC = 5;

    @Override
    public List<ExamResponse> getExamByTopicId(String topicId) {
        List<Exam> examList = examRepository.findExamsByTopic_Id(topicId);

        return examList.stream().map(examMapper::toExamResponse).toList();
    }

    @Override
    @Transactional
    public ExamResponse createExam(String topicId) throws InvalidException {
        List<WordResponse> words = new ArrayList<>(topicService.getWords(topicId));

        if (words.size() < MIN_WORD_IN_TOPIC) {
            throw new InvalidException(ExamMessage.WORD_SIZE_MIN_5);
        }

        // Tạo exam trước để lấy Id
        Exam exam = Exam.builder()
                .totalQuestions(words.size())
                .topic(Topic.builder().id(topicId).build())
                .build();

        examRepository.saveAndFlush(exam);
        // Tạo các câu hỏi
        List<QuestionResponse> questionList = questionService.generateRandomQuestions(words, exam);

        // Trả về exam sau khi các câu hỏi được tạo
        ExamResponse examResponse = examMapper.toExamResponse(exam);
        examResponse.setQuestions(questionList);

        return examResponse;
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
}
