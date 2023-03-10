package ru.itis.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {"pets"}, callSuper = false)
@Table(name = "animal_type")
public class AnimalTypeEntity extends AbstractEntity {

    @Column(length = 64)
    private String name;

    @OneToMany(mappedBy = "animalType", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private Set<PetEntity> pets;
}
