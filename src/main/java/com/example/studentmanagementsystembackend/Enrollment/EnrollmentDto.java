package com.example.studentmanagementsystembackend.Enrollment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDto {
    public Long id;
    public LocalDate date;
    public Long studentId;
    public Long courseId;

}
