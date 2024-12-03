package org.kdp.learn_vocabulary_kdp.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class IdWordType implements Serializable {
    @Column(name = "word_id")
    private String wordId;

    @Column(name = "type_id")
    private String typeId;
}
