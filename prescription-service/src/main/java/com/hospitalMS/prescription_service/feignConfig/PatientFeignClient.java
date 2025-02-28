package com.hospitalMS.prescription_service.feignConfig;

import com.hospitalMS.prescription_service.entity.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "patient-service", path = "/api/patients")
public interface PatientFeignClient {

    @GetMapping("/{id}")
    Optional<Patient> getPatientById(@PathVariable String id);

}
