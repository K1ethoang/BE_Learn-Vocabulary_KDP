/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/22 - 17:16 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.impl;

import java.text.MessageFormat;
import java.util.Date;
import java.util.UUID;

import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.kdp.learn_vocabulary_kdp.entity.Token;
import org.kdp.learn_vocabulary_kdp.entity.User;
import org.kdp.learn_vocabulary_kdp.enums.ERole;
import org.kdp.learn_vocabulary_kdp.exception.InvalidException;
import org.kdp.learn_vocabulary_kdp.exception.NotFoundException;
import org.kdp.learn_vocabulary_kdp.message.UserMessage;
import org.kdp.learn_vocabulary_kdp.model.dto.request.auth.LoginRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.user.UserCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.response.user.UserResponse;
import org.kdp.learn_vocabulary_kdp.model.mapper.UserMapper;
import org.kdp.learn_vocabulary_kdp.repository.RoleRepository;
import org.kdp.learn_vocabulary_kdp.repository.TokenRepository;
import org.kdp.learn_vocabulary_kdp.repository.UserRepository;
import org.kdp.learn_vocabulary_kdp.service.interfaces.AuthService;
import org.kdp.learn_vocabulary_kdp.service.interfaces.MailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthServiceImpl implements AuthService {
    // 10 phút = 60 * 10
    long EXPIRY_TIME_TOKEN = 600;
    TokenRepository tokenRepository;
    UserRepository userRepository;
    RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;
    UserMapper userMapper;
    MailService mailService;

    @NonFinal
    @Value("${frontend.domain}")
    String frontendDomain;

    @Override
    public UserResponse login(LoginRequest request) throws InvalidException, NotFoundException {
        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() -> new NotFoundException(UserMessage.USER_NOT_FOUND));

        if (Boolean.FALSE.equals(user.getIsActive())) {
            throw new InvalidException(UserMessage.VERIFY_EMAIL);
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new InvalidException(UserMessage.PASSWORD_INCORRECT);
        }

        if (Boolean.TRUE.equals(user.getIsBlock())) {
            throw new InvalidException(UserMessage.USER_BLOCKED);
        }

        return userMapper.toUserResponse(user);
    }

    @Transactional
    @Override
    public UserResponse register(UserCreationRequest userCreationRequest) throws InvalidException, MessagingException {
        // Tạo tài khoản với trạng thái active mặc định là false
        if (userRepository.existsUserByEmail(userCreationRequest.getEmail())) {
            throw new InvalidException(UserMessage.EMAIL_EXIST);
        }

        User user = userMapper.toUser(userCreationRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEmail(userCreationRequest.getEmail().toLowerCase());
        user.setRole(roleRepository.findByName(ERole.USER.getName()));
        userRepository.save(user);

        // Gửi token
        saveAndSendToken(user);

        return userMapper.toUserResponse(user);
    }

    @Override
    public void verifyToken(String token, String email) throws InvalidException {
        // Kiểm tra user đã được xác minh chưa
        User user =
                userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException(UserMessage.USER_NOT_FOUND));
        checkUserActivated(user);

        // Nếu chưa thì đến kiểm tra token
        // Kiểm tra token có hợp lệ không
        Token tokenFromDb =
                tokenRepository.findById(token).orElseThrow(() -> new InvalidException(UserMessage.TOKEN_INVALID));

        // Kiểm tra token còn hiệu lực
        if (tokenFromDb.getExpiryTime().before(new Date())) {
            // Xoá token để sau này dữ liệu không bị thừa
            tokenRepository.delete(tokenFromDb);
            throw new InvalidException(UserMessage.TOKEN_EXPIRED);
        }

        // Đặt lại trạng thái Active cho user
        user.setIsActive(true);
        // Sau khi active xong thì xoá token
        tokenRepository.delete(tokenFromDb);
    }

    @Override
    public void resendVerifyToken(String email) throws MessagingException, NotFoundException {
        User user =
                userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException(UserMessage.USER_NOT_FOUND));
        checkUserActivated(user);

        saveAndSendToken(user);
    }

    private void saveAndSendToken(User user) throws MessagingException {
        // Tạo token xác thực
        String token = UUID.randomUUID().toString();
        // Cài đặt thời gian token hết hạn
        Date expiryTime = Date.from(new Date().toInstant().plusSeconds(EXPIRY_TIME_TOKEN));
        tokenRepository.save(
                Token.builder().tokenId(token).user(user).expiryTime(expiryTime).build());

        // Gửi mail
        String confirmationUrl = MessageFormat.format(
                "{0}/verify-account" + "?token={1}" + "&email={2}", frontendDomain, token, user.getEmail());
        mailService.sendMailVerifyAccount(user.getEmail(), confirmationUrl);
    }

    private void checkUserActivated(User user) throws InvalidException {
        if (Boolean.TRUE.equals(user.getIsActive())) {
            throw new InvalidException(UserMessage.ACCOUNT_ACTIVATED);
        }
    }
}
