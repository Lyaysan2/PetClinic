package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.request.AppointmentRequest;
import ru.itis.dto.response.AppointmentInfoResponse;
import ru.itis.exception.ProjectBadRequestException;
import ru.itis.model.*;
import ru.itis.repository.AppointmentRepository;
import ru.itis.service.*;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final UserService userService;
    private final PetService petService;
    private final DoctorService doctorService;
    private final ServiceService serviceService;
    private final TimeSlotService timeSlotService;

    private final AppointmentRepository appointmentRepository;

    @Override
    public AppointmentInfoResponse makeAppointment(AppointmentRequest appointmentRequest) {
        UserEntity user = userService.getById(appointmentRequest.getUserId());
        PetEntity pet = petService.getById(appointmentRequest.getPetId());
        DoctorEntity doctor = doctorService.getById(appointmentRequest.getDoctorId());
        ServiceEntity service = serviceService.getById(appointmentRequest.getServiceId());
        TimeSlotEntity timeSlot = timeSlotService.getById(appointmentRequest.getTimeSlotId());

        if (!pet.getUser().getId().equals(user.getId())) {
            throw new ProjectBadRequestException("Pet does not belong to the user");
        }

        if (!doctor.getDepartment().getId().equals(service.getDepartment().getId())) {
            throw new ProjectBadRequestException("Doctor does not belong to the service");
        }

        if (!timeSlot.getDoctor().getId().equals(doctor.getId())) {
            throw new ProjectBadRequestException("Timeslot does not belong to the doctor");
        }

        if (timeSlot.getIsBooked()) {
            throw new ProjectBadRequestException("Time slot already booked");
        }

        AppointmentEntity appointment = AppointmentEntity.builder()
                .user(user)
                .pet(pet)
                .doctor(doctor)
                .service(service)
                .timeSlot(timeSlot)
                .build();

        appointmentRepository.save(appointment);

        timeSlot.setIsBooked(true);
        timeSlotService.save(timeSlot);

        return AppointmentInfoResponse.builder()
                .petName(pet.getName())
                .fullDoctorName(String.format("%s %s %s", doctor.getLastName(), doctor.getFirstName(), doctor.getMiddleName()))
                .serviceName(service.getName())
                .servicePrice(service.getPrice())
                .appointmentDate(timeSlot.getDate())
                .startTime(timeSlot.getStartTime().atZone(ZoneId.of("GMT+3")).toLocalTime()
                        .format(DateTimeFormatter.ofPattern("HH:mm")))
                .build();
    }
}
