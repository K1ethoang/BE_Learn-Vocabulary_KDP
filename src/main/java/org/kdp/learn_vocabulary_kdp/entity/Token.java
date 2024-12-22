/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/22 - 15:43 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity(name = "tokens")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Token {
    @Id
    @Column(name = "token_id")
    String tokenId;

    @Column(name = "expiry_time")
    @Temporal(TemporalType.TIMESTAMP)
    Date expiryTime;

    @OneToOne
    @JoinColumn(nullable = false, name = "user_id")
    User user;
}
