/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/17 - 22:53 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorResponse {
    int statusCode;
    List<ErrorDetail> errors;
}
