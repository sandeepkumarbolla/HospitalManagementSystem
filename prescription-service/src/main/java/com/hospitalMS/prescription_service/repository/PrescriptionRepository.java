package com.hospitalMS.prescription_service.repository;

import com.hospitalMS.prescription_service.entity.Prescription;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrescriptionRepository  extends MongoRepository<Prescription,String> {
}
