package com.hospitalMS.Doctor_service.service;

import com.hospitalMS.Doctor_service.entity.Doctor;
import com.hospitalMS.Doctor_service.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // Add a new doctor
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Method to check if the doctor has a specific slot available
    public boolean isSlotAvailable(Long doctorId, int slot){
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);

        return doctor.map(value -> value.getAvailableSlots().contains(slot)).orElse(false);
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Get doctor by name
    public Optional<Doctor> getDoctorByName(String name) {
        return doctorRepository.findByName(name);
    }

    // Get doctor by specialization
    public Optional<Doctor> getDoctorBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }

    // Delete a doctor by ID
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    public Optional<Doctor> getDoctorById(Long doctorId) {
        return doctorRepository.findById(doctorId);
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
