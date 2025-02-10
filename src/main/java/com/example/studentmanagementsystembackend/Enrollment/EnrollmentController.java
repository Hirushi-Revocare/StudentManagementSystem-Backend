package com.example.studentmanagementsystembackend.Enrollment;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/enrollment")

public class EnrollmentController {
    private EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<EnrollmentDto> createEnrollment(@RequestBody EnrollmentDto enrollmentDto){
        EnrollmentDto savedEnrollment = enrollmentService.createEnrollment(enrollmentDto);
        return new ResponseEntity<>(savedEnrollment, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EnrollmentDto> getEnrollmentById(@PathVariable("id") Long enrollmentId){
        EnrollmentDto enrollmentDto = enrollmentService.getEnrollmentById(enrollmentId);
        return ResponseEntity.ok(enrollmentDto);
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentDto>>getAllEnrollments(){
        List<EnrollmentDto> enrollmentDtos = enrollmentService.getAllEnrollments();
        return ResponseEntity.ok(enrollmentDtos);
    }

    @PutMapping("{id}")
    public ResponseEntity<EnrollmentDto> updateEnrollment(@PathVariable Long enrollmentId, @RequestBody EnrollmentDto updatedEnrollment){
        EnrollmentDto enrollmentDto = enrollmentService.updateEnrollment(enrollmentId, updatedEnrollment);
        return ResponseEntity.ok(enrollmentDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEnrollment(@PathVariable Long enrollmentId){
        enrollmentService.deleteEnrollment(enrollmentId);
        return ResponseEntity.ok("Record Deleted Successfully");
    }
}
