/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/11 - 23:07 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.model.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kdp.learn_vocabulary_kdp.message.UserMessage;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginDto {
    @Email(message = UserMessage.EMAIL_FORMAT)
    @NotBlank(message = UserMessage.EMAIL_REQUIRED)
    private String email;

    @NotBlank(message = UserMessage.PASSWORD_REQUIRED)
    @Size(min = UserMessage.PASSWORD_MIN_LENGTH, max = UserMessage.PASSWORD_MAX_LENGTH, message = UserMessage.PASSWORD_FORMAT)
    private String password;
}
