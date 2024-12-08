package org.kdp.learn_vocabulary_kdp.service.impl;

import lombok.AllArgsConstructor;
import org.kdp.learn_vocabulary_kdp.entity.User;
import org.kdp.learn_vocabulary_kdp.exception.InvalidException;
import org.kdp.learn_vocabulary_kdp.exception.NotFoundException;
import org.kdp.learn_vocabulary_kdp.model.dto.auth.LoginDto;
import org.kdp.learn_vocabulary_kdp.model.dto.auth.RegisterDto;
import org.kdp.learn_vocabulary_kdp.repository.UserRepository;
import org.kdp.learn_vocabulary_kdp.service.interfaces.AuthService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    UserRepository userRepository;

    @Override
    public void login(LoginDto loginDto) throws NotFoundException {
        User user = userRepository.findUserByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());

        if (user == null) {
            throw new NotFoundException("User not found");
        }
    }

    @Override
    public void register(RegisterDto registerDto) throws InvalidException {
        User user = User.builder().email(registerDto.getEmail()).password(registerDto.getPassword()).fullName(registerDto.getFullName()).build();
        userRepository.save(user);

        if (user.getId() == null) {
            throw new InvalidException("User is duplicated");
        }
    }
}
