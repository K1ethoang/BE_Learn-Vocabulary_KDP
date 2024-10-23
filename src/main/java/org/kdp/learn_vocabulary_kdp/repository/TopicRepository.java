package org.kdp.learn_vocabulary_kdp.repository;

import org.kdp.learn_vocabulary_kdp.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, String> {
}
