package com.hospitalMS.prescription_service.service;

import com.hospitalMS.prescription_service.entity.Patient;
import com.hospitalMS.prescription_service.entity.Prescription;
import com.hospitalMS.prescription_service.feignConfig.PatientFeignClient;
import com.hospitalMS.prescription_service.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;


    private final PatientFeignClient patientFeignClient;

    public PrescriptionService(PrescriptionRepository prescriptionRepository, PatientFeignClient patientFeignClient) {
        this.prescriptionRepository = prescriptionRepository;
        this.patientFeignClient = patientFeignClient;
    }

    // Save prescription
    public Prescription savePrescription(Prescription prescription) {
        Optional<Patient> patient = patientFeignClient.getPatientById(prescription.getPatient().getPatientId());
        System.out.println(patient.get().getName());
        prescription.setPatient(patient.get());

        return prescriptionRepository.save(prescription);
    }

    // Get all prescriptions
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    // Get prescription by ID
    public Prescription getPrescriptionById(String id) {
        Optional<Prescription> prescription = prescriptionRepository.findById(id);
        return prescription.orElseThrow(() -> new RuntimeException("Prescription not found"));
    }

    // Update prescription
    public Prescription updatePrescription(String id, Prescription updatedPrescription) {
        if (!prescriptionRepository.existsById(id)) {
            throw new RuntimeException("Prescription not found");
        }
        updatedPrescription.setPrescriptionId(id);
        return prescriptionRepository.save(updatedPrescription);
    }

    // Delete prescription
    public void deletePrescription(String id) {
        if (!prescriptionRepository.existsById(id)) {
            throw new RuntimeException("Prescription not found");
        }
        prescriptionRepository.deleteById(id);
    }

}
