package com.hospitalMS.Appointment_service.feignConfig;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class DoctorFeignClientFallback{
//    @Override
//    public DoctorFeignClient create(Throwable cause) {
//        return (doctorId, slot) -> {
//            // Log the exception cause
//            System.out.println("Doctor Service is down! Cause: " + cause.getMessage());
//            return false; // Default response when service is unavailable
//        };
//    }
}
