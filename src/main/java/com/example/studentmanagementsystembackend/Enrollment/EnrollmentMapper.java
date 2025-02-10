package com.example.studentmanagementsystembackend.Enrollment;

public class EnrollmentMapper {
    public static EnrollmentDto mapToEnrollmentDto(Enrollment enrollment){
        return new EnrollmentDto(
                enrollment.getId(),
                enrollment.getDate(),
                enrollment.getStudent().getId(),
                enrollment.getCourse().getId()
        );
    }
    public static Enrollment mapToEnrollment(EnrollmentDto enrollmentDto){
        return new Enrollment(
                enrollmentDto.getId(),
                enrollmentDto.getDate(),
                enrollmentDto.getCourseId(),
                enrollmentDto.getStudentId()
        );
    }
}
