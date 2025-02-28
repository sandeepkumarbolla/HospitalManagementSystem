package com.hospitalMS.prescription_service.entity;

public class Doctor {
    private String doctorId;
    private String name;
    private String specialization;
    private String contact;

    // Constructors
    public Doctor() {}

    public Doctor(String doctorId, String name, String specialization,String contact) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.contact = contact;
    }

    // Getters and Setters
    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
}
