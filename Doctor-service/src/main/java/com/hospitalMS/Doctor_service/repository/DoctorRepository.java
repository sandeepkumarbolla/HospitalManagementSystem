package com.hospitalMS.Doctor_service.repository;

import com.hospitalMS.Doctor_service.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByName(String name);
    Optional<Doctor> findBySpecialization(String specialization);
}
