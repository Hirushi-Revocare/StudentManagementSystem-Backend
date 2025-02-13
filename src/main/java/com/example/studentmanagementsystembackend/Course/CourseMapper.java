package com.example.studentmanagementsystembackend.Course;

import com.example.studentmanagementsystembackend.Department.Department;

public class CourseMapper {
    public static CourseDto mapToCourseDto(Course course){
        return new CourseDto(
                course.getId(),
                course.getCourseCode(),
                course.getName(),
                course.getCredits(),
                course.getDepartment().getId()
        );
    }
    public static Course mapToCourse(CourseDto courseDto, Department department){
        return new Course(
                courseDto.getId(),
                courseDto.getCourseCode(),
                courseDto.getName(),
                courseDto.getCredits(),
                department
        );
    }
}
