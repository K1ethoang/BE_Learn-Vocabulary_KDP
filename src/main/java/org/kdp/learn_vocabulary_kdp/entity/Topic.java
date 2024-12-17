/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/16 - 18:32 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity(name = "topics")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Topic extends Auditable {
    @Id
    @UuidGenerator
    @Column(name = "topic_id")
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "topic", fetch = FetchType.LAZY)
    private List<Quizz> quizzes;

    @OneToMany(mappedBy = "topic", fetch = FetchType.LAZY)
    private List<Word> words;
}
