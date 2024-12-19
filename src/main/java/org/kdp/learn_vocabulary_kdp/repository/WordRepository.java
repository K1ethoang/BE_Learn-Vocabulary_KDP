/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/20 - 00:00 AM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.repository;

import org.kdp.learn_vocabulary_kdp.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, String> {
    boolean existsWordByNameAndTopic_Id(String name, String topicId);

    boolean existsWordByNameAndTopic_IdAndIdNot(String name, String topicId, String id);
}
