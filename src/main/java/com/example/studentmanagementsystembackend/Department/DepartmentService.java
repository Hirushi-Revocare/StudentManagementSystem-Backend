package com.example.studentmanagementsystembackend.Department;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(Long departmentId);
    List<DepartmentDto> getAllDepartments();
    DepartmentDto updateDepartment(Long departmentId,DepartmentDto updatedDepartment);
    void deleteDepartment(Long departmentId);
}
