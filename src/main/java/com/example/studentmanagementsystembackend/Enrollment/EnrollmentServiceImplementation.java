package com.example.studentmanagementsystembackend.Enrollment;

import com.example.studentmanagementsystembackend.Exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EnrollmentServiceImplementation implements EnrollmentService{
    private EnrollmentRepository enrollmentRepository;
    @Override
    public EnrollmentDto createEnrollment(EnrollmentDto enrollmentDto) {
        Enrollment enrollment = EnrollmentMapper.mapToEnrollment(enrollmentDto);
        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
        return EnrollmentMapper.mapToEnrollmentDto(savedEnrollment);
    }

    @Override
    public EnrollmentDto getEnrollmentById(Long enrollmentId) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId).orElseThrow(()->new ResourceNotFoundException("Enrollment not found"));
        return EnrollmentMapper.mapToEnrollmentDto(enrollment);
    }

    @Override
    public List<EnrollmentDto> getAllEnrollments() {
        List<Enrollment> enrollments = enrollmentRepository.findAll();
        return enrollments.stream().map(enrollment-> EnrollmentMapper.mapToEnrollmentDto(enrollment)).collect(Collectors.toList());
    }

    @Override
    public EnrollmentDto updateEnrollment(Long enrollmentId, EnrollmentDto updatedEnrollment) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId).orElseThrow(()->new ResourceNotFoundException("Enrollment Not Found"));
        enrollment.setDate(updatedEnrollment.getDate());
        Enrollment updatedEnrollmentObj = enrollmentRepository.save(enrollment);
        return EnrollmentMapper.mapToEnrollmentDto(updatedEnrollmentObj);
    }

    @Override
    public void deleteEnrollment(Long enrollmentId) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId).orElseThrow(()-> new ResourceNotFoundException("Enrollment not found"));
        enrollmentRepository.deleteById(enrollmentId);

    }
}
