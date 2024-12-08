package org.kdp.learn_vocabulary_kdp.model.dto.auth;

import lombok.Data;

@Data
public class RegisterDto {
    private String fullName;
    private String email;
    private String password;
}
