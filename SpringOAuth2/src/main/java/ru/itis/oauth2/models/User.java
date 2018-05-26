package ru.itis.oauth2.models;

import lombok.*;
import ru.itis.oauth2.security.role.Role;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 03.11.2017
 * User
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "rest_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String login;

    private String hashPassword;

    @Enumerated(value = EnumType.STRING)
    private Role role;
}
