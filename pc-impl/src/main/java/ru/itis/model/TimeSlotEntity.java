package ru.itis.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {"doctor", "appointment"}, callSuper = false)
@Table(name = "time_slot")
public class TimeSlotEntity extends AbstractEntity {

    private Instant date;

    @Column(name = "start_time")
    private Instant startTime;

    @Column(name = "end_time")
    private Instant endTime;

    @Column(name = "is_booked")
    private Boolean isBooked;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;

    @OneToOne(mappedBy = "timeSlot", fetch = FetchType.LAZY)
    private AppointmentEntity appointment;
}
