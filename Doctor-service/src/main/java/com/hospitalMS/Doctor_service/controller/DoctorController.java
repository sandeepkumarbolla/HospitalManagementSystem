package com.hospitalMS.Doctor_service.controller;


import com.hospitalMS.Doctor_service.entity.Doctor;
import com.hospitalMS.Doctor_service.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // Endpoint to add a new doctor


    // Endpoint to check availability for a slot
    @GetMapping("/checkSlotAvailability")
    public ResponseEntity<Boolean> checkAvailability(@RequestParam Long doctorId, @RequestParam int slot){
        boolean isAvailable = doctorService.isSlotAvailable(doctorId, slot);
        System.out.println(isAvailable);
        return ResponseEntity.ok(isAvailable);
    }

    // Get all doctors
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    //get doctor by ID
    @GetMapping("/id")
    public Optional<Doctor> getDoctorById(@RequestParam Long doctorId){
        return doctorService.getDoctorById(doctorId);
    }

    // Get doctor by name
    @GetMapping("/name/{name}")
    public ResponseEntity<Doctor> getDoctorByName(@PathVariable String name) {
        Optional<Doctor> doctor = doctorService.getDoctorByName(name);
        return doctor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get doctor by specialization
    @GetMapping("/specialization/{specialization}")
    public ResponseEntity<Doctor> getDoctorBySpecialization(@PathVariable String specialization) {
        Optional<Doctor> doctor = doctorService.getDoctorBySpecialization(specialization);
        return doctor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add a new doctor
    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Doctor newDoctor = doctorService.addDoctor(doctor);
        return ResponseEntity.ok(newDoctor);
    }

    // Delete a doctor by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/update")
    public ResponseEntity<Doctor> updateDoctor(@RequestParam Long id, @RequestBody Doctor doctorDetails) {
        Optional<Doctor> existingDoctor = doctorService.getDoctorById(id);
        if (existingDoctor.isPresent()) {
            Doctor doctor = existingDoctor.get();
            doctor.setAvailableSlots(doctorDetails.getAvailableSlots());

            Doctor updatedDoctor = doctorService.saveDoctor(doctor);  // Save the updated doctor
            return ResponseEntity.ok(updatedDoctor);  // Return the updated doctor
        } else {
            return ResponseEntity.notFound().build();  // Return 404 if doctor not found
        }
    }

}
