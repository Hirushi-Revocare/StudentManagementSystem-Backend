package com.example.studentmanagementsystembackend.Course;

import com.example.studentmanagementsystembackend.Department.Department;
import com.example.studentmanagementsystembackend.Student.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CourseService {
    CourseDto createCourse(CourseDto courseDto);
    CourseDto getCourseById(Long courseId);
    List<CourseDto> getAllCourses();
    CourseDto updateCourse(Long courseId, CourseDto updatedCourse);
    void deleteCourse(Long courseId);

}
