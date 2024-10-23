package org.kdp.learn_vocabulary_kdp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Table(name = "types")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Type {
    @Id
    @UuidGenerator
    @Column(name = "type_id")
    private String id;

    private String type;

    @OneToMany(mappedBy = "type")
    private List<WordType> wordTypes;
}
