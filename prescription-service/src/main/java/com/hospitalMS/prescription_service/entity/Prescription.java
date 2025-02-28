package com.hospitalMS.prescription_service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Document(collection = "prescriptions")
public class Prescription {

    @Id
    private String prescriptionId;
    private LocalDate date;
    private Patient patient;
    private Doctor doctor;
    private String diagnosis;
    private List<String> symptoms;
    private List<Medication> medications;
    private List<Tests> tests;
    private FollowUp followUp;
    private String additionalNotes;

    // Constructors
    public Prescription() {}

    public Prescription(String prescriptionId, LocalDate date, Patient patient, Doctor doctor, String diagnosis,
                        List<String> symptoms, List<Medication> medications, List<Tests> tests,
                        FollowUp followUp, String additionalNotes) {
        this.prescriptionId = prescriptionId;
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
        this.diagnosis = diagnosis;
        this.symptoms = symptoms;
        this.medications = medications;
        this.tests = tests;
        this.followUp = followUp;
        this.additionalNotes = additionalNotes;
    }

    // Getters and Setters
    public String getPrescriptionId() { return prescriptionId; }
    public void setPrescriptionId(String prescriptionId) { this.prescriptionId = prescriptionId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public List<String> getSymptoms() { return symptoms; }
    public void setSymptoms(List<String> symptoms) { this.symptoms = symptoms; }

    public List<Medication> getMedications() { return medications; }
    public void setMedications(List<Medication> medications) { this.medications = medications; }

    public List<Tests> getTests() { return tests; }
    public void setTests(List<Tests> tests) { this.tests = tests; }

    public FollowUp getFollowUp() { return followUp; }
    public void setFollowUp(FollowUp followUp) { this.followUp = followUp; }

    public String getAdditionalNotes() { return additionalNotes; }
    public void setAdditionalNotes(String additionalNotes) { this.additionalNotes = additionalNotes; }
}
