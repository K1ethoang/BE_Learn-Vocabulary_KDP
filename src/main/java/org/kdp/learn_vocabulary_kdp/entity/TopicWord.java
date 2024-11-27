package org.kdp.learn_vocabulary_kdp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "topic_word")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TopicWord {
    @Id
    @UuidGenerator
    @Column(name = "topic_word_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "word_id")
    private Word word;
}
