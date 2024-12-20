/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/20 - 21:44 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.model.dto.response.user;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date updatedAt;

    String id;

    String fullName;

    String email;

    String avatar;

    Boolean isBlocked;

    String role;
}
