/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/16 - 18:33 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Table(name = "words")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Word extends Auditable {
    @Id
    @UuidGenerator
    @Column(name = "word_id")
    String id;

    @Column(name = "name")
    String name;

    @Column(name = "pronounce")
    String pronounce;

    @Column(name = "meaning")
    String meaning;

    @Column(name = "example", columnDefinition = "TEXT")
    String example;

    @Column(name = "Has_Remembered")
    Boolean hasRemembered;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    Topic topic;

    @OneToMany(mappedBy = "word")
    List<WordType> wordTypes;
}
