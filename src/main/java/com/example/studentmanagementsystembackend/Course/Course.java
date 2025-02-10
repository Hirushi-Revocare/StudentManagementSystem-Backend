package com.example.studentmanagementsystembackend.Course;

import com.example.studentmanagementsystembackend.Department.Department;
import com.example.studentmanagementsystembackend.Enrollment.Enrollment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "course")
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long id;
    @Getter
    @Column(name = "course_code")
    private String courseCode;
    @Getter
    @Column(name = "course_name")
    private String name;
    @Column(name = "credits")
    private Float credits;

    public Course() {
    }

    public Course(Long id, String courseCode, String name, Float credits, Set<Enrollment> enrollments, Department department) {
        this.id = id;
        this.courseCode = courseCode;
        this.name = name;
        this.credits = credits;
        this.enrollments = enrollments;
        this.department = department;
    }

    public Course(String courseCode, String name, Float credits, Set<Enrollment> enrollments, Department department) {
        this.courseCode = courseCode;
        this.name = name;
        this.credits = credits;
        this.enrollments = enrollments;
        this.department = department;
    }

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<Enrollment> enrollments;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_ID",nullable = false)
    private Department department;

    public Course(Long id, String courseCode, String name, Float credits) {
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseCode='" + courseCode + '\'' +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", enrollments=" + enrollments +
                ", department=" + department +
                '}';
    }
}
