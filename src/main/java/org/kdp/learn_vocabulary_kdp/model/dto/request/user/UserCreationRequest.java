/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/20 - 21:43 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.model.dto.request.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.jackson.TrimDeserializer;
import org.kdp.learn_vocabulary_kdp.message.GlobalMessage;
import org.kdp.learn_vocabulary_kdp.message.UserMessage;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @NotBlank(message = GlobalMessage.REQUIRED)
    @Size(
            min = UserMessage.FULLNAME_MIN_LENGTH,
            max = UserMessage.FULLNAME_MAX_LENGTH,
            message = UserMessage.FULLNAME_FORMAT)
    @JsonDeserialize(using = TrimDeserializer.class)
    String fullName;

    @Email(message = UserMessage.EMAIL_FORMAT)
    @NotBlank(message = GlobalMessage.REQUIRED)
    @JsonDeserialize(using = TrimDeserializer.class)
    String email;

    @NotBlank(message = GlobalMessage.REQUIRED)
    @Size(
            min = UserMessage.PASSWORD_MIN_LENGTH,
            max = UserMessage.PASSWORD_MAX_LENGTH,
            message = UserMessage.PASSWORD_FORMAT)
    String password;
}
