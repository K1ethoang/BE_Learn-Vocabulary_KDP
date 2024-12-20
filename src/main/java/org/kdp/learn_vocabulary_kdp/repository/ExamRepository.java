/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/20 - 20:48 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.repository;

import org.kdp.learn_vocabulary_kdp.entity.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, String> {
    Page<Exam> findAllByTopic_Id(String topicId, Pageable pageable);
}
