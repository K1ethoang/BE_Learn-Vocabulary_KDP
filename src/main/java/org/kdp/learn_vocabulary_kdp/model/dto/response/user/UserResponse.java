/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/14 - 19:42 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.model.dto.response.user;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd")
    Date updatedAt;

    String id;

    String fullName;

    @JsonIgnore
    String password;

    String email;

    String avatar;

    Boolean isBlocked;

    String role;
}
