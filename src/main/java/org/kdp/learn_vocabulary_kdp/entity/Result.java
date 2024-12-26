/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/26 - 15:16 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

@Entity(name = "results")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    @Id
    @UuidGenerator
    @Column(name = "result_id")
    String id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    Date createdAt;

    @Column(name = "correct_count", nullable = false)
    int correctCount;

    @Column(name = "details", columnDefinition = "JSON")
    String details;

    @OneToOne
    @JoinColumn(nullable = false, name = "exam_id")
    Exam exam;
}
