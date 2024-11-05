package org.kdp.learn_vocabulary_kdp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class NotFoundException extends RuntimeException{
    private final HttpStatus httpStatus = HttpStatus.NOT_FOUND;
    private String message;
}
