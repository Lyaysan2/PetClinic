package ru.itis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "refresh_token")
public class RefreshTokenEntity extends AbstractEntity {

    @Column(name = "expiry_date", nullable = false)
    private Instant expiryDate;

    @OneToOne(mappedBy = "refreshToken")
    private UserEntity user;
}
