package ru.itis.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.itis.dto.enums.Role;
import ru.itis.dto.enums.State;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {"refreshToken", "appointments", "pets"}, callSuper = false)
@Table(name = "users")
public class UserEntity extends AbstractEntity {

    @Column(name = "first_name", length = 64)
    private String firstName;

    @Column(name = "last_name", length = 64)
    private String lastName;

    @Column(unique = true, nullable = false, updatable = false, length = 64)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(length = 12)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(length = 32)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(length = 32)
    private State state;

    @OneToOne
    @JoinColumn(name = "refresh_token_id")
    private RefreshTokenEntity refreshToken;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private Set<AppointmentEntity> appointments;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private Set<PetEntity> pets;
}
