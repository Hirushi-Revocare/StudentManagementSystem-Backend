package com.example.studentmanagementsystembackend.Student;
import com.example.studentmanagementsystembackend.Department.Department;
import com.example.studentmanagementsystembackend.Department.DepartmentRepository;
import com.example.studentmanagementsystembackend.Exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImplementation implements StudentService {
    private StudentRepository studentRepository;
    private DepartmentRepository departmentRepository;
    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Department department = departmentRepository.findById(studentDto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));
        Student student = StudentMapper.mapToStudent(studentDto, department);
        if (student.getDepartment() == null) {
            throw new IllegalArgumentException("Department cannot be null");
        }
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(()->new ResourceNotFoundException("Student does not exist with the given Id: "+ studentId));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        return students.stream().map((student) -> StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto updatedStudent) {
        Student student= studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("Student is not found with the given ID" + studentId));
        Department department = departmentRepository.findById(updatedStudent.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with ID: " + updatedStudent.getDepartmentId()));
        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());
        student.setDob(updatedStudent.getDob());
        student.setDepartment(department);
        Student updatedStudentObj = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(updatedStudentObj);
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student is not found with the given Id" + studentId));
        studentRepository.deleteById(studentId);
    }
}
