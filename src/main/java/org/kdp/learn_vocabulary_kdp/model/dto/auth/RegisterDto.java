/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/11 - 15:51 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.model.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.kdp.learn_vocabulary_kdp.message.UserMessage;

@Data
public class RegisterDto {
    @NotBlank(message = UserMessage.FULLNAME_REQUIRED)
    @Size(min = UserMessage.FULLNAME_MIN_LENGTH, max = UserMessage.FULLNAME_MAX_LENGTH, message = UserMessage.FULLNAME_FORMAT)
    @JsonProperty("full_name")
    private String fullName;

    @Email(message = UserMessage.EMAIL_FORMAT)
    @NotBlank(message = UserMessage.EMAIL_REQUIRED)
    private String email;

    @NotBlank(message = UserMessage.PASSWORD_REQUIRED)
    @Size(min = UserMessage.PASSWORD_MIN_LENGTH, max = UserMessage.PASSWORD_MAX_LENGTH, message = UserMessage.PASSWORD_FORMAT)
    private String password;
}
