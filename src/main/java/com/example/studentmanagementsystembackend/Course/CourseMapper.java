package com.example.studentmanagementsystembackend.Course;

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
    public static Course mapToCourse(CourseDto courseDto){
        return new Course(
                courseDto.getId(),
                courseDto.getCourseCode(),
                courseDto.getName(),
                courseDto.getCredits()
        );
    }
}
