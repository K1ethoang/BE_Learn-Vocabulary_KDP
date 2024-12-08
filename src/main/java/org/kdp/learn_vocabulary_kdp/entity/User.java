package org.kdp.learn_vocabulary_kdp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends Auditable {
    @Id
    @UuidGenerator
    @Column(name = "user_id")
    private String id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "is_blocked")
    private Boolean isBlocked;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Topic> topics;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Quizz> quizzes;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Word> words;

    @Transient
    private String refreshToken;

    @Transient
    private String accessToken;

    @Transient
    private String expRefreshToken;
}
