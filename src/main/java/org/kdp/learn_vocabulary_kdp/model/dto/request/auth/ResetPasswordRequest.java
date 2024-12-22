/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/22 - 23:47 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.model.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.message.GlobalMessage;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResetPasswordRequest {
    @NotBlank(message = GlobalMessage.REQUIRED)
    String email;
    @NotBlank(message = GlobalMessage.REQUIRED)
    String newPassword;
}
