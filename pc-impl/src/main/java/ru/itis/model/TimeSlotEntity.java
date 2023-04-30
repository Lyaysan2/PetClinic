package ru.itis.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {"doctor", "appointment"}, callSuper = false)
@Table(name = "time_slot")
public class TimeSlotEntity extends AbstractEntity {

    private LocalDate date;

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
