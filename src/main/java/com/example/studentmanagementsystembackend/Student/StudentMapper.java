package com.example.studentmanagementsystembackend.Student;

import com.example.studentmanagementsystembackend.Department.Department;

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
    public static Student mapToStudent(StudentDto studentDto, Department department){
        return new Student(
                studentDto.getId(),
                studentDto.getName(),
                studentDto.getEmail(),
                studentDto.getDob(),
                department
        );
    }
}
