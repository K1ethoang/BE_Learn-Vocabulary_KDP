/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/19 - 15:56 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.model.dto.response.type;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TypeResponse {
    String id;

    String name;

    String symbol;

    String description;
}
