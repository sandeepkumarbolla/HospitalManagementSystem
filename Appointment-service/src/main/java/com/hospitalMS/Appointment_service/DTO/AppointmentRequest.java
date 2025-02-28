package com.hospitalMS.Appointment_service.DTO;

public class AppointmentRequest {
    private Long doctorId;
    private String patientName;
    private String patientContact;
    private Integer appointmentTime;  // Time in 24-hour format (e.g., 10 for 10:00 AM)

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
}
