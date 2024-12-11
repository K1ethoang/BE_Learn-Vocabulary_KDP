package org.kdp.learn_vocabulary_kdp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Table(name = "words")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Word extends Auditable {
    @Id
    @UuidGenerator
    @Column(name = "word_id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "pronounce")
    private String pronounce;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "word")
    private List<TopicWord> topicWords;

    @OneToMany(mappedBy = "word")
    private List<WordType> wordTypes;
}
