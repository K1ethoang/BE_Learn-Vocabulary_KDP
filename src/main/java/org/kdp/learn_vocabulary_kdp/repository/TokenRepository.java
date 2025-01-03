/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/22 - 16:08 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.repository;

import org.kdp.learn_vocabulary_kdp.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, String> {}
