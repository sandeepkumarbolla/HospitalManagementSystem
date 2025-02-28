package com.hospitalMS.Patient_service.service;

import com.hospitalMS.Patient_service.entity.Patient;
import com.hospitalMS.Patient_service.entity.PatientHistory;
import com.hospitalMS.Patient_service.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Create or Update a Patient
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Get a Patient by ID
    public Optional<Patient> getPatientById(String id) {
        return patientRepository.findById(id);
    }

    // Get all Patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Delete a Patient by ID
    public void deletePatient(String patientId) {
        patientRepository.deleteById(patientId);
    }

    // Find Patient by Email
    public Patient getPatientByEmail(String email) {
        return patientRepository.findByEmail(email);
    }
}
