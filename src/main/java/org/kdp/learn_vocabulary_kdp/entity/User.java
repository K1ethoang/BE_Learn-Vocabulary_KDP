package org.kdp.learn_vocabulary_kdp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Table(name = "users")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends Auditable {
    @Id
    @UuidGenerator
    @Column(name = "user_id")
    private String id;

    @Column(name = "full_name")
    private String fullName;

    private String password;

    private String email;

    private String username;

    private String avatar;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "is_blocked")
    private Boolean isBlocked;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<Topic> topics;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "quizze_id")
    private List<Quizze> quizzes;

    @OneToMany(mappedBy = "user")
    private List<UserWord> userWord;

    @Transient
    private String refreshToken;

    @Transient
    private String accessToken;

    @Transient
    private String expRefreshToken;
}
