/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/26 - 17:47 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;
import org.kdp.learn_vocabulary_kdp.entity.converter.ListToJsonConverter;

@Entity(name = "questions")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Question {
    @Id
    @UuidGenerator
    @Column(name = "question_id")
    String id;

    @Column(name = "question", nullable = false)
    String question;

    @Column(name = "options", columnDefinition = "JSON")
    @Convert(converter = ListToJsonConverter.class) // Sử dụng converter tự định nghĩa
    List<String> options;

    String answer;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    Exam exam;
}
