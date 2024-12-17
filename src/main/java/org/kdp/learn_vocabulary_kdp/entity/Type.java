/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/16 - 16:46 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity(name = "types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Type {
    @Id
    @UuidGenerator
    @Column(name = "type_id")
    String id;

    @Column(name = "name")
    String name;

    @Column(name = "symbol", length = 10)
    String symbol;

    @Column(name = "description", columnDefinition = "TEXT")
    String description;

    @OneToMany(mappedBy = "type")
    List<WordType> wordTypes;
}
