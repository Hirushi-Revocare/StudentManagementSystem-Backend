package com.example.studentmanagementsystembackend.Enrollment;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnrollmentService {
    EnrollmentDto createEnrollment(EnrollmentDto enrollmentDto);
    EnrollmentDto getEnrollmentById(Long enrollmentId);
    List<EnrollmentDto> getAllEnrollments();
    EnrollmentDto updateEnrollment(Long enrollmentId,EnrollmentDto updatedEnrollment);
    void deleteEnrollment(Long enrollmentId);
}
