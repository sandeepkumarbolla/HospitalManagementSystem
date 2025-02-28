package com.hospitalMS.Appointment_service.feignConfig;

import com.hospitalMS.Appointment_service.entity.Doctor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
//url = "${doctor-service.url}"

@FeignClient(name = "doctor-service", path = "/api/doctors")
public interface DoctorFeignClient {
    @GetMapping("/checkSlotAvailability")
    boolean isSlotAvailable(@RequestParam("doctorId") Long doctorId, @RequestParam("slot") int slot);

    @GetMapping("/id")
    Optional<Doctor> getDoctorById(@RequestParam Long doctorId);

    @PutMapping("/update")
    ResponseEntity<Doctor> updateDoctor(@RequestParam Long id, @RequestBody Doctor doctorDetails);
}

