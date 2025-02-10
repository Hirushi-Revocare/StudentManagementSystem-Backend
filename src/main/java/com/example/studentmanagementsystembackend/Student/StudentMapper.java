package com.example.studentmanagementsystembackend.Student;
public class StudentMapper {
    public static StudentDto mapToStudentDto(Student student){
        return new StudentDto(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getDob(),
                student.getDepartment().getId()
        );
    }
    public static Student mapToStudent(StudentDto studentDto){
        return new Student(
                studentDto.getId(),
                studentDto.getName(),
                studentDto.getEmail(),
                studentDto.getDob(),
                studentDto.getDepartmentId()
        );
    }
}
