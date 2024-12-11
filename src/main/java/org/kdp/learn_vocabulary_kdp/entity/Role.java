package org.kdp.learn_vocabulary_kdp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @UuidGenerator
    @Column(name = "role_id")
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> users;
}
