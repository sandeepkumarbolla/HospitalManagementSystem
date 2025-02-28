package com.hospitalMS.Appointment_service.repository;

import com.hospitalMS.Appointment_service.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // You can add custom queries, for example, to find appointments by doctor or by status
    boolean existsByDoctorIdAndAppointmentTime(Long doctorId, Integer appointmentTime);
}
