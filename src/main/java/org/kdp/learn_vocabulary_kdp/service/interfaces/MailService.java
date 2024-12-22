/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/22 - 23:14 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.interfaces;

import jakarta.mail.MessagingException;
import org.kdp.learn_vocabulary_kdp.entity.User;

public interface MailService {
    void sendMailVerifyAccount(User user, String confirmationUrl) throws MessagingException;

    void sendMailResetPassword(User user, String resetPasswordUrl) throws MessagingException;
}
