package org.kdp.learn_vocabulary_kdp.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class IdTopicWord implements Serializable {
    @Column(name = "topic_id")
    private String topicId;

    @Column(name = "word_id")
    private String wordId;
}
