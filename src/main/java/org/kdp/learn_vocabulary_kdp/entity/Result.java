/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/26 - 13:02 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;

@Entity(name = "results")
@Getter
@Setter
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

    @Column(name = "correct_count",nullable = false)
    int correctCount;

    @Column(name = "details", columnDefinition = "JSON")
    String details;

    @OneToOne
    @JoinColumn(nullable = false, name = "exam_id")
    Exam exam;
}
