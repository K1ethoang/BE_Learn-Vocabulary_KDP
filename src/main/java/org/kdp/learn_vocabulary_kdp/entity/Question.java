/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/26 - 13:06 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;

@Entity(name = "questions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Question {
    @Id
    @UuidGenerator
    @Column(name = "question_id")
    String questionId;

    @Column(name = "question", nullable = false)
    String question;

    @Column(name = "options", columnDefinition = "JSON")
    String options;

    String answer;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    Exam exam;
}
