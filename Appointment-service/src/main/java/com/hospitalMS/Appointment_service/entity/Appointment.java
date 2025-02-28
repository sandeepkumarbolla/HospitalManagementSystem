package com.hospitalMS.Appointment_service.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    private Long doctorId; // Foreign key to Doctor
    private String patientName;
    private String patientContact;
    private Integer appointmentTime; // Time in 24-hour integer format (e.g., 9 for 9:00 AM)
    private String status; // Pending, Completed, etc.

    private LocalDateTime createdAt; // When the appointment was created

    // Constructors, Getters, and Setters
    public Appointment() {
    }

    public Appointment(Long doctorId, String patientName, String patientContact, Integer appointmentTime, String status) {
        this.doctorId = doctorId;
        this.patientName = patientName;
        this.patientContact = patientContact;
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.createdAt = LocalDateTime.now();
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientContact() {
        return patientContact;
    }

    public void setPatientContact(String patientContact) {
        this.patientContact = patientContact;
    }

    public Integer getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Integer appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

