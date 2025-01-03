/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/26 - 15:13 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.repository;

import java.util.List;

import org.kdp.learn_vocabulary_kdp.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, String> {

    List<Exam> findExamsByTopic_Id(String topicId);
}
