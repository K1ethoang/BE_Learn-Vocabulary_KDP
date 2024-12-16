/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/16 - 12:52 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity(name = "types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Type {
    @Id
    @UuidGenerator
    @Column(name = "type_id")
    private String id;

    private String name;
    
    private String symbol;

    @OneToMany(mappedBy = "type")
    private List<WordType> wordTypes;
}
