/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/20 - 21:51 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.model.dto.request.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.message.GlobalMessage;
import org.kdp.learn_vocabulary_kdp.message.UserMessage;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginRequest {
    @Email(message = UserMessage.EMAIL_FORMAT)
    @NotBlank(message = GlobalMessage.REQUIRED)
    String email;

    @NotBlank(message = GlobalMessage.REQUIRED)
    @Size(min = UserMessage.PASSWORD_MIN_LENGTH, message = UserMessage.PASSWORD_FORMAT_MIN)
    String password;
}
