package org.kdp.learn_vocabulary_kdp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Table(name = "words")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Word extends Auditable {
    @Id
    @UuidGenerator
    @Column(name = "word_id")
    private String id;

    private String word;

    private String pronounce;

    @OneToMany(mappedBy = "word")
    private List<UserWord> userWord;

    @OneToMany(mappedBy = "word")
    private List<WordType> wordTypes;
}
