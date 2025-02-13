package com.example.studentmanagementsystembackend.Enrollment;

import com.example.studentmanagementsystembackend.Course.Course;
import com.example.studentmanagementsystembackend.Course.CourseRepository;
import com.example.studentmanagementsystembackend.Department.Department;
import com.example.studentmanagementsystembackend.Department.DepartmentRepository;
import com.example.studentmanagementsystembackend.Exception.ResourceNotFoundException;
import com.example.studentmanagementsystembackend.Student.Student;
import com.example.studentmanagementsystembackend.Student.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EnrollmentServiceImplementation implements EnrollmentService{
    private EnrollmentRepository enrollmentRepository;
    private CourseRepository courseRepository;
    private StudentRepository studentRepository;
    @Override
    public EnrollmentDto createEnrollment(EnrollmentDto enrollmentDto) {
        Course course = courseRepository.findById(enrollmentDto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));
        Student student = studentRepository.findById(enrollmentDto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Enrollment enrollment = EnrollmentMapper.mapToEnrollment(enrollmentDto,course,student);
        if (enrollment.getCourse() == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        if (enrollment.getStudent() == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
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
