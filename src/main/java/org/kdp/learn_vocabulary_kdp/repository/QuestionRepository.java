/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/26 - 22:12 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.repository;

import java.util.List;

import org.kdp.learn_vocabulary_kdp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
    List<Question> findQuestionsByExam_Id(String examId);
}
