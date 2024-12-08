package org.kdp.learn_vocabulary_kdp.service.interfaces;

import org.kdp.learn_vocabulary_kdp.model.dto.auth.LoginDto;
import org.kdp.learn_vocabulary_kdp.model.dto.auth.RegisterDto;

public interface AuthService {
    void login(LoginDto loginDto);

    void register(RegisterDto registerDto);
}
