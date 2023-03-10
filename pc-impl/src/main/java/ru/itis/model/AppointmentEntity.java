package ru.itis.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {"user", "pet", "doctor", "service", "timeSlot"}, callSuper = false)
@Table(name = "appointment")
public class AppointmentEntity extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "pet_id")
    private PetEntity pet;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "service_id")
    private ServiceEntity service;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "time_slot_id")
    private TimeSlotEntity timeSlot;
}
