package org.kdp.learn_vocabulary_kdp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kdp.learn_vocabulary_kdp.entity.keys.IdTopicWord;

@Entity(name = "topics_words")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TopicWord {
    @Id
    private IdTopicWord idTopicWord;

    @Column(name = "meaning")
    private String meaning;

    @Column(name = "example", columnDefinition = "TEXT")
    private String example;

    @Column(name = "has_remembered")
    private Boolean hasRemembered;

    @ManyToOne
    @JoinColumn(name = "topic_id", insertable = false, updatable = false)
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "word_id", insertable = false, updatable = false)
    private Word word;
}
