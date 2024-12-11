/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/11 - 23:02 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.model.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date createdAt;

    @JsonProperty("updated_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date updatedAt;

    @JsonIgnore
    String id;

    @JsonProperty("full_name")
    String fullName;

    @JsonIgnore
    String password;
    String email;
    String avatar;

    @JsonProperty("is_blocked")
    Boolean isBlocked;
}
