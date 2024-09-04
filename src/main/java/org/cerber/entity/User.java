package org.cerber.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Table(schema = "public", name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "uuid", nullable = false)
    private String uuid;

    @Column(name = "subscribed", nullable = false)
    private Boolean subscribed;

}
