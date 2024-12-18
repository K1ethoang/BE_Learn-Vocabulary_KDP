/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/18 - 02:07 AM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.message.GlobalMessage;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorDetail {

    @Schema(example = "general")
    String field;

    @Schema(example = GlobalMessage.AUTHENTICATED)
    String message;
}
