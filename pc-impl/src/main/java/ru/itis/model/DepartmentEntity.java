package ru.itis.model;
import lombok.*;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.*;

import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {"services", "doctors"}, callSuper = false)
@Table(name = "department")
public class DepartmentEntity extends AbstractEntity{

    @Column(length = 64)
    private String name;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private Set<ServiceEntity> services;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private Set<DoctorEntity> doctors;
}
