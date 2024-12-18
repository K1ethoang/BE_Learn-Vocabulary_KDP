/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/14 - 19:19 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LearnVocabularyKdpApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnVocabularyKdpApplication.class, args);
    }
}
