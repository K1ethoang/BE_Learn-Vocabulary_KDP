/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/22 - 14:01 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;

@Entity(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends Auditable {
    @Id
    @UuidGenerator
    @Column(name = "user_id")
    String id;

    @Column(name = "full_name")
    String fullName;

    @Column(name = "password")
    @JsonIgnore
    String password;

    @Column(name = "email", unique = true)
    String email;

    @Column(name = "avatar")
    String avatar;

    @Builder.Default
    @Column(name = "block")
    Boolean isBlock = Boolean.FALSE;

    @Builder.Default
    @Column(name = "active")
    Boolean isActive = Boolean.FALSE;

    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<Topic> topics;

    @OneToOne(mappedBy = "user")
    Token token;
}
