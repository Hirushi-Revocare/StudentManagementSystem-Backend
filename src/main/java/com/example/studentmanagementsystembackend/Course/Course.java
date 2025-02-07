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

    public Course(Long id, String courseCode, String name, Float credits) {
        this.id = id;
        this.courseCode = courseCode;
        this.name = name;
        this.credits = credits;
    }

    public Course(String courseCode, String name, Float credits) {
        this.courseCode = courseCode;
        this.name = name;
        this.credits = credits;
    }
    @OneToMany(mappedBy = "course")
    private Set<Enrollment> enrollments;

    @ManyToOne
    @JoinColumn(name = "department_ID",nullable = false)
    private Department department;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseCode='" + courseCode + '\'' +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", enrollments=" + enrollments +
                '}';
    }
}
