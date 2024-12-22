/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/22 - 15:50 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.interfaces;

import jakarta.mail.MessagingException;

public interface MailService {
    void sendMailVerifyAccount(String toEmail, String confirmationUrl) throws MessagingException;
}
