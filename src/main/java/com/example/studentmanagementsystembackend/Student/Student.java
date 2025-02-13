package com.example.studentmanagementsystembackend.Student;
import com.example.studentmanagementsystembackend.Department.Department;
import com.example.studentmanagementsystembackend.Enrollment.Enrollment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    @Getter
    @Column (name = "student_Name")
    private String name;
    @Getter
    @Column (name = "email", nullable=false, unique = true)
    private String email;
    @Getter
    @Column(name = "dob")
    private LocalDate dob;


    public Student() {
    }

    public Student(Long id, String name, String email, LocalDate dob, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.department = department;
    }

    public Student(String name, String email, LocalDate dob, Department department) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.department = department;
    }

    @ManyToOne
    @JoinColumn(name = "department_Id", nullable = false)
    private Department department;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Enrollment> enrollments;

    public Student(Long id, String name, String email, LocalDate dob, Long departmentId) {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", department=" + department +
                '}';
    }
}
