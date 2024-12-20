/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/19 - 23:46 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.repository;

import org.kdp.learn_vocabulary_kdp.entity.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, String> {
    boolean existsTopicByTitleAndUser_Id(String title, String userId);

    boolean existsTopicByTitleAndUser_IdAndIdNot(String title, String userId, String topicId);

    Page<Topic> findAllByUserId(String userId, Pageable pageable);
}
