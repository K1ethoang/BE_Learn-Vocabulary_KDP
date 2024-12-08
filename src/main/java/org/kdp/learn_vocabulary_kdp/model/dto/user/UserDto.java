/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/08 - 01:33 AM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.model.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link org.kdp.learn_vocabulary_kdp.entity.User}
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserDto implements Serializable {
    Date createdAt;
    Date updatedAt;
    String id;
    String fullName;
    String password;
    String email;
    String avatar;
    Boolean isBlocked;
}
