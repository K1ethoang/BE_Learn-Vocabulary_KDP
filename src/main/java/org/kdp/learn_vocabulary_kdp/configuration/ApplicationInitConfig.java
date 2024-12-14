/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/14 - 19:37 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.configuration;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.kdp.learn_vocabulary_kdp.entity.Role;
import org.kdp.learn_vocabulary_kdp.entity.User;
import org.kdp.learn_vocabulary_kdp.enums.ERole;
import org.kdp.learn_vocabulary_kdp.repository.RoleRepository;
import org.kdp.learn_vocabulary_kdp.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {
    RoleRepository roleRepository;
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            if (roleRepository.findByName(ERole.ADMIN.getName()) == null) {
                roleRepository.save(Role.builder().name(ERole.ADMIN.getName()).build());
            }

            if (roleRepository.findByName(ERole.USER.getName()) == null) {
                roleRepository.save(Role.builder().name(ERole.USER.getName()).build());
            }

            if (userRepository.findByEmail("kiethoang101@gmail.com").isEmpty()) {
                Role role = roleRepository.findByName(ERole.ADMIN.getName());

                User user = User.builder().email("kiethoang101@gmail.com").password(passwordEncoder.encode("12345678")).fullName("admin").role(role).build();

                userRepository.save(user);

                log.warn("Admin user has been created with: 'kiethoang101@gmail.com/12345678', " + "please change password");
            }
        };
    }
}
