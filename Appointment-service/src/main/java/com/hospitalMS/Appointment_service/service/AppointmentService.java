package com.hospitalMS.Appointment_service.service;

import com.hospitalMS.Appointment_service.DTO.AppointmentRequest;
import com.hospitalMS.Appointment_service.entity.Appointment;
import com.hospitalMS.Appointment_service.entity.Doctor;
import com.hospitalMS.Appointment_service.feignConfig.DoctorFeignClient;
import com.hospitalMS.Appointment_service.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorFeignClient doctorFeignClient; // Inject Feign Client

    private final String doctorServiceUrl = "http://doctor-service/api/doctor/checkSlotAvailability";

    // Method to schedule an appointment
    public ResponseEntity<String> scheduleAppointment(AppointmentRequest appointmentRequest) {

        // Call Doctor Service using Feign Client
        boolean isAvailable = doctorFeignClient.isSlotAvailable(appointmentRequest.getDoctorId(), appointmentRequest.getAppointmentTime());

        if (!isAvailable) {
            return new ResponseEntity<>("The selected time slot is not available for the doctor.", HttpStatus.BAD_REQUEST);
        }

        // If slot is available, create an appointment and save it
        Appointment appointment = new Appointment();
        appointment.setDoctorId(appointmentRequest.getDoctorId());
        appointment.setPatientName(appointmentRequest.getPatientName());
        appointment.setPatientContact(appointmentRequest.getPatientContact());
        appointment.setAppointmentTime(appointmentRequest.getAppointmentTime());
        appointment.setStatus("Pending");
        appointment.setCreatedAt(java.time.LocalDateTime.now());

        // Save the appointment to the repository
        appointmentRepository.save(appointment);

//        Optional<Doctor> doctor = doctorFeignClient.getDoctorById(appointment.getDoctorId());
        Doctor doctor = doctorFeignClient.getDoctorById(appointment.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        doctor.getAvailableSlots().remove(appointmentRequest.getAppointmentTime());

        System.out.println(doctor.getAvailableSlots());
        doctorFeignClient.updateDoctor(doctor.getId(),doctor);

        return new ResponseEntity<>("Appointment successfully scheduled at " + appointmentRequest.getAppointmentTime(), HttpStatus.CREATED);
    }


}
