package com.example.studentmanagementsystembackend.Department;
import com.example.studentmanagementsystembackend.Course.Course;
import com.example.studentmanagementsystembackend.Student.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "department")
public class Department {
    @Getter
    @Id
    @SequenceGenerator(
            name = "department_Sequence",
            sequenceName = "department_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_sequence"
    )
    private Long id;
    @Getter
    @Column(name = "department_Name")
    private String name;

    public Department() {
    }

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Student> students;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Course> courses;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
