package org.kdp.learn_vocabulary_kdp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "quizzes")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quizze {
    @Id
    @UuidGenerator
    @Column(name = "quizze_id")
    private String id;

    @Column(name = "total_questions")
    private int totalQuestions;

    @Column(name = "correct_answers")
    private int correctAnswers;

    @CreatedDate
    @Column(name = "date_completed", nullable = false, updatable = false)
    private LocalDateTime dateCompleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}
