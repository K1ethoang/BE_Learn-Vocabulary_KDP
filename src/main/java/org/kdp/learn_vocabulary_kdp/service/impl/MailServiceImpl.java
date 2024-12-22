/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/22 - 23:15 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.impl;

import java.util.HashMap;
import java.util.Map;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.entity.User;
import org.kdp.learn_vocabulary_kdp.service.interfaces.MailService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MailServiceImpl implements MailService {
    JavaMailSender javaMailSender;
    TemplateEngine templateEngine;

    @Override
    public void sendMailVerifyAccount(User user, String confirmationUrl) throws MessagingException {
        Context context = new Context();

        Map<String, Object> variables = new HashMap<>();
        variables.put("name", user.getFullName());
        variables.put("ConfirmationUrl", confirmationUrl);
        context.setVariables(variables);

        // Render template thành chuỗi HTML
        String htmlContent = templateEngine.process("mail-verify-account", context);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        helper.setTo(user.getEmail());
        helper.setSubject("KDP - Đăng ký thành công");
        helper.setText(htmlContent, true);

        javaMailSender.send(mimeMessage);
    }

    @Override
    public void sendMailResetPassword(User user, String resetPasswordUrl) throws MessagingException {
        Context context = new Context();

        Map<String, Object> variables = new HashMap<>();
        variables.put("name", user.getFullName());
        variables.put("resetPasswordUrl", resetPasswordUrl);
        context.setVariables(variables);

        // Render template thành chuỗi HTML
        String htmlContent = templateEngine.process("reset-password", context);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        helper.setTo(user.getEmail());
        helper.setSubject("KDP - Đặt lại mật khẩu");
        helper.setText(htmlContent, true);

        javaMailSender.send(mimeMessage);
    }
}
