/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/16 - 18:35 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kdp.learn_vocabulary_kdp.entity.keys.IdWordType;

@Entity(name = "words_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WordType {
    @Id
    private IdWordType idWordType;

    @ManyToOne
    @JoinColumn(name = "word_id", insertable = false, updatable = false)
    private Word word;

    @ManyToOne
    @JoinColumn(name = "type_id", insertable = false, updatable = false)
    private Type type;
}
