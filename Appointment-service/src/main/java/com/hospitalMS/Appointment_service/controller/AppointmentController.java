package com.hospitalMS.Appointment_service.controller;

import com.hospitalMS.Appointment_service.DTO.AppointmentRequest;
import com.hospitalMS.Appointment_service.entity.Appointment;
import com.hospitalMS.Appointment_service.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/schedule")
    public ResponseEntity<String> scheduleAppointment(@RequestBody AppointmentRequest appointmentRequest) {
        // Call the service method to schedule the appointment
        return appointmentService.scheduleAppointment(appointmentRequest);
    }





//
//    // Endpoint to update appointment status
//    @PutMapping("/{appointmentId}/status")
//    public ResponseEntity<Appointment> updateAppointmentStatus(@PathVariable Long appointmentId,
//                                                               @RequestParam String status) {
//        Appointment updatedAppointment = appointmentService.updateAppointmentStatus(appointmentId, status);
//        return ResponseEntity.ok(updatedAppointment);
//    }
//
//    // Endpoint to get appointment details
//    @GetMapping("/{appointmentId}")
//    public ResponseEntity<Appointment> getAppointmentDetails(@PathVariable Long appointmentId) {
//        Appointment appointment = appointmentService.getAppointmentDetails(appointmentId);
//        return ResponseEntity.ok(appointment);
//    }
}
