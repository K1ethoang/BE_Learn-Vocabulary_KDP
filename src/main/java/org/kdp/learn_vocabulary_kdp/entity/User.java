/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/13 - 21:58 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends Auditable implements UserDetails {
    @Id
    @UuidGenerator
    @Column(name = "user_id")
    private String id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "password")
    @JsonIgnore
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return isBlocked;
    }
}
