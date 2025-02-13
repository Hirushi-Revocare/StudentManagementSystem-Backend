package com.example.studentmanagementsystembackend.Enrollment;

import com.example.studentmanagementsystembackend.Course.Course;
import com.example.studentmanagementsystembackend.Department.Department;
import com.example.studentmanagementsystembackend.Student.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "enrollment")
public class Enrollment {
    @Id
    @SequenceGenerator(
            name = "enrollment_sequence",
            sequenceName = "enrollment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "enrollment_sequence"
    )
    private Long id;
    @Getter
    @Column(name = "enrollment_date")
    private LocalDate date;

    public Enrollment() {
    }

    public Enrollment(Long id, LocalDate date, Course course, Student student) {
        this.id = id;
        this.date = date;
        this.course = course;
        this.student = student;
    }

    public Enrollment(LocalDate date, Course course, Student student) {
        this.date = date;
        this.course = course;
        this.student = student;
    }

    public Enrollment(Long id, LocalDate date, Long courseId, Long studentId) {
    }


    @ManyToOne
    @JoinColumn(name = "course_Id",nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "student_Id", nullable = false)
    private Student student;
    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", date=" + date +
                ", course=" + course +
                ", student=" + student +
                '}';
    }
}

