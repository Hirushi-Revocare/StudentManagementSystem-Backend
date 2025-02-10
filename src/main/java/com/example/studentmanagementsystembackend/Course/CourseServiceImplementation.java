package com.example.studentmanagementsystembackend.Course;

import com.example.studentmanagementsystembackend.Exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseServiceImplementation implements CourseService{
    private CourseRepository courseRepository;

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        Course course = CourseMapper.mapToCourse(courseDto);
        if (course.getDepartment() == null) {
            throw new IllegalArgumentException("Department cannot be null");
        }
        courseRepository.save(course);
        Course savedCourse = courseRepository.save(course);
        return CourseMapper.mapToCourseDto(savedCourse);
    }

    @Override
    public CourseDto getCourseById(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(()->new ResourceNotFoundException("Course not found"));
        return CourseMapper.mapToCourseDto(course);
    }

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return  courses.stream().map(course -> CourseMapper.mapToCourseDto(course)).collect(Collectors.toList());
    }

    @Override
    public CourseDto updateCourse(Long courseId, CourseDto updatedCourse) {
        Course course = courseRepository.findById(courseId).orElseThrow(()->new ResourceNotFoundException("Course not found"));
        course.setCourseCode(updatedCourse.getCourseCode());
        course.setName(updatedCourse.getName());
        course.setCredits(updatedCourse.getCredits());
        Course updatedCourseObj = courseRepository.save(course);
        return CourseMapper.mapToCourseDto(updatedCourseObj);
    }

    @Override
    public void deleteCourse(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("course not found"));
        courseRepository.deleteById(courseId);
    }
}
