package com.example.studentmanagementsystembackend.Enrollment;


import com.example.studentmanagementsystembackend.Course.Course;
import com.example.studentmanagementsystembackend.Department.Department;
import com.example.studentmanagementsystembackend.Student.Student;

public class EnrollmentMapper {
    public static EnrollmentDto mapToEnrollmentDto(Enrollment enrollment){
        return new EnrollmentDto(
                enrollment.getId(),
                enrollment.getDate(),
                enrollment.getStudent().getId(),
                enrollment.getCourse().getId()
        );
    }
    public static Enrollment mapToEnrollment(EnrollmentDto enrollmentDto, Course course, Student student){
        return new Enrollment(
                enrollmentDto.getId(),
                enrollmentDto.getDate(),
                course,
                student
        );
    }
}
