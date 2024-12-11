/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/11 - 14:55 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class InvalidException extends RuntimeException {
    private final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
    private String message;
}
