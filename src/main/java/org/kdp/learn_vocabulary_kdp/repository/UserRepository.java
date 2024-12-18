/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/12 - 11:48 AM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.repository;

import java.util.Optional;

import org.kdp.learn_vocabulary_kdp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);

    boolean existsUserByEmail(String email);
}
