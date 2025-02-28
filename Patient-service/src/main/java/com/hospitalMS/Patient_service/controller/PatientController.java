package com.hospitalMS.Patient_service.controller;

import com.hospitalMS.Patient_service.entity.Patient;
import com.hospitalMS.Patient_service.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // Create or Update Patient
    @PostMapping
    public Patient savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }


    // Get Patient by ID
    @GetMapping("/{id}")
    public Optional<Patient> getPatientById(@PathVariable String id) {
        return patientService.getPatientById(id);
    }

    // Get All Patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    // Delete Patient by ID
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable String id) {
        patientService.deletePatient(id);
    }

    // Get Patient by Email
    @GetMapping("/email/{email}")
    public Patient getPatientByEmail(@PathVariable String email) {
        return patientService.getPatientByEmail(email);
    }
}
