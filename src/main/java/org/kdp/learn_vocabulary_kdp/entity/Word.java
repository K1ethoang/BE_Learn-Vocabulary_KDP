/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/19 - 23:02 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;

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

    @Column(name = "has_remembered")
    Boolean hasRemembered;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    Topic topic;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "words_types",
            joinColumns = @JoinColumn(name = "word_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id"))
    List<Type> types;
}
