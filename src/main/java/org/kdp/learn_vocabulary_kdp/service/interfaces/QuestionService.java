/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/26 - 22:10 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.interfaces;

import java.util.List;

import org.kdp.learn_vocabulary_kdp.entity.Exam;
import org.kdp.learn_vocabulary_kdp.model.dto.request.exam.Answer;
import org.kdp.learn_vocabulary_kdp.model.dto.response.question.QuestionResponse;
import org.kdp.learn_vocabulary_kdp.model.dto.response.word.WordResponse;

public interface QuestionService {
    List<QuestionResponse> generateRandomQuestions(List<WordResponse> wordList, Exam exam);

    int checkCorrectAnswer(List<Answer> answers, String examId);
}
