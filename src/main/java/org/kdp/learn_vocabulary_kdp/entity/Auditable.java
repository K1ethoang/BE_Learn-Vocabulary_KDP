/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/11 - 23:04 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.entity;


import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public abstract class Auditable {
    @CreatedDate
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at", nullable = false, updatable = false)
    protected Date createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    protected Date updatedAt;
}
