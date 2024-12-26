/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/26 - 15:16 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

@Entity(name = "exams")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Exam {
    @Id
    @UuidGenerator
    @Column(name = "exam_id")
    String id;

    @Column(name = "total_questions")
    int totalQuestions;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    Date createdAt;

    @OneToMany(mappedBy = "exam")
    List<Question> questions;

    @OneToOne(mappedBy = "exam")
    Result result;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    Topic topic;
}
