/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/18 - 02:11 AM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.message.GlobalMessage;

@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SuccessResponse {
    @Schema(example = "201")
    int statusCode;

    @Schema(example = GlobalMessage.SUCCESSFULLY)
    String message;

    @Schema(example = "Object")
    Object result;
}
