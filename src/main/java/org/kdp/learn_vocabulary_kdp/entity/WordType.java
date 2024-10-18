package org.kdp.learn_vocabulary_kdp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "word_type")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WordType {
    @Id
    @UuidGenerator
    @Column(name = "word_type_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "word_id")
    private Word word;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    private String definition;
     
    private String description;
}
