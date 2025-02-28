package com.hospitalMS.prescription_service.controller;

import com.hospitalMS.prescription_service.entity.Prescription;
import com.hospitalMS.prescription_service.service.PrescriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    // ✅ Create a new prescription
    @PostMapping
    public ResponseEntity<Prescription> createPrescription(@RequestBody Prescription prescription) {
        Prescription savedPrescription = prescriptionService.savePrescription(prescription);
        return ResponseEntity.ok(savedPrescription);
    }

    // ✅ Get all prescriptions
    @GetMapping
    public ResponseEntity<List<Prescription>> getAllPrescriptions() {
        return ResponseEntity.ok(prescriptionService.getAllPrescriptions());
    }

    // ✅ Get prescription by ID
    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable String id) {
        return ResponseEntity.ok(prescriptionService.getPrescriptionById(id));
    }

    // ✅ Update prescription
    @PutMapping("/{id}")
    public ResponseEntity<Prescription> updatePrescription(@PathVariable String id, @RequestBody Prescription updatedPrescription) {
        Prescription prescription = prescriptionService.updatePrescription(id, updatedPrescription);
        return ResponseEntity.ok(prescription);
    }

    // ✅ Delete prescription
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePrescription(@PathVariable String id) {
        prescriptionService.deletePrescription(id);
        return ResponseEntity.ok("Prescription deleted successfully");
    }
}
