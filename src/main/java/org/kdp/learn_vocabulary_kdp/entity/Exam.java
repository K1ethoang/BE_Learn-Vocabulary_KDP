/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/26 - 19:11 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
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

    @Column(name = "correct_count")
    int correctCount;

    @Column(name = "start_at", updatable = false)
    Date startAt;

    @Column(name = "end_at", updatable = false)
    Date endAt;

    @OneToMany(mappedBy = "exam", fetch = FetchType.LAZY)
    List<Question> questions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    Topic topic;
}
