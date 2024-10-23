package org.kdp.learn_vocabulary_kdp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_word")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserWord {
    @Id
    @UuidGenerator
    @Column(name = "user_word_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "word_id")
    private Word word;

    @Column(name = "updated_status_at")
    private LocalDateTime updatedStatusAt;

    @Column(name = "has_remembered")
    private Boolean HasRemembered;
}
