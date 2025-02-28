package com.hospitalMS.Patient_service.repository;

import com.hospitalMS.Patient_service.entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient,String> {
    Patient findByEmail(String email);
}
