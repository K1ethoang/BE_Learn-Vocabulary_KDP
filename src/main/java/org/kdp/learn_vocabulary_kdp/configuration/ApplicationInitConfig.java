/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/17 - 21:57 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.configuration;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.kdp.learn_vocabulary_kdp.entity.Role;
import org.kdp.learn_vocabulary_kdp.entity.Type;
import org.kdp.learn_vocabulary_kdp.entity.User;
import org.kdp.learn_vocabulary_kdp.enums.ERole;
import org.kdp.learn_vocabulary_kdp.repository.RoleRepository;
import org.kdp.learn_vocabulary_kdp.repository.TypeRepository;
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
    TypeRepository typeRepository;
    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            // Init data for Role entity
            if (roleRepository.count() == 0) {
                roleRepository.save(Role.builder().name(ERole.ADMIN.getName()).build());
                log.info("Init: ADMIN");

                roleRepository.save(Role.builder().name(ERole.USER.getName()).build());
                log.info("Init: USER");
            }

            // Init admin account
            if (userRepository.findByEmail("kiethoang101@gmail.com").isEmpty()) {
                Role role = roleRepository.findByName(ERole.ADMIN.getName());

                User user = User.builder()
                        .email("kiethoang101@gmail.com")
                        .password(passwordEncoder.encode("12345678"))
                        .fullName("admin")
                        .role(role)
                        .isBlocked(false)
                        .build();

                userRepository.save(user);
                log.warn("Init account: Admin user has been created with: " + "'kiethoang101@gmail.com/12345678', "
                        + "please change password");
            }

            // Init data for Type entity
            if (typeRepository.count() == 0) {
                typeRepository.save(Type.builder()
                        .symbol("N")
                        .name("Noun")
                        .description("A person, place, thing, or idea.\nExample: cat, dog, house...")
                        .build());
                log.info("Init: Noun (N)");

                typeRepository.save(Type.builder()
                        .symbol("V")
                        .name("Verb")
                        .description("An action word.\nExample: run, jump, eat, think...")
                        .build());
                log.info("Init: Verb (V)");

                typeRepository.save(Type.builder()
                        .symbol("Adj")
                        .name("Adjective")
                        .description("A word that describes a noun.\nExample: big, small, happy, sad...")
                        .build());
                log.info("Init: Adjective (Adj)");

                typeRepository.save(Type.builder()
                        .symbol("Prep")
                        .name("Preposition")
                        .description(
                                "A word that shows the relationship between nouns, pronouns, and other words in a sentence.\nExample: in, on, at, with...")
                        .build());
                log.info("Init: Preposition (Prep)");

                typeRepository.save(Type.builder()
                        .symbol("Det")
                        .name("Determiner")
                        .description("A word that modifies a noun.\nExample: the, a, an, this, that...")
                        .build());
                log.info("Init: Determiner (Det)");

                typeRepository.save(Type.builder()
                        .symbol("Conj")
                        .name("Conjunction")
                        .description("A word that joins words phrases, or clauses.\nExample: and, but, or, because...")
                        .build());
                log.info("Init: Conjunction (Conj)");

                typeRepository.save(Type.builder()
                        .symbol("Intj")
                        .name("Interjection")
                        .description("A word or phrase that expresses strong emotion.\nExample: Wow!, Oh no!, Hey!...")
                        .build());
                log.info("Init: Interjection (Intj)");
            }
        };
    }
}
