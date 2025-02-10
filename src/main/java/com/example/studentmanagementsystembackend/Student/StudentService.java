package com.example.studentmanagementsystembackend.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentById(Long studentId);
    List<StudentDto> getAllStudents();
    StudentDto updateStudent(Long studentId, StudentDto updatedStudent);
    void deleteStudent(Long studentId);
}
