package org.kdp.learn_vocabulary_kdp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Table(name = "topics")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Topic extends Auditable {
    @Id
    @UuidGenerator
    @Column(name = "topic_id")
    private String id;

    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToMany
    @JoinTable(
            name = "topic_word",
            joinColumns = @JoinColumn(name = "topic_id"),
            inverseJoinColumns = @JoinColumn(name = "word_id")
    )
    private List<Word> words;
}
