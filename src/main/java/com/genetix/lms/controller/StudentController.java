package com.genetix.lms.controller;

import com.genetix.lms.model.*;
import com.genetix.lms.repository.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final CourseRepository courseRepo;
    private final EnrollmentRepository enrollRepo;
    private final UserRepository userRepo;

    public StudentController(CourseRepository courseRepo, EnrollmentRepository enrollRepo, UserRepository userRepo) {
        this.courseRepo = courseRepo;
        this.enrollRepo = enrollRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseRepo.findAll());
    }

    @GetMapping("/list")
    public ResponseEntity<List<User>>  getAllStudent(){
        return ResponseEntity.ok(userRepo.findAll());
    }
    @PostMapping("/enroll/{courseId}/{studentId}")
    public ResponseEntity<Enrollment> enroll(@PathVariable Long courseId, @PathVariable Long studentId) {
        User student = userRepo.findById(studentId).orElseThrow();
        Course course = courseRepo.findById(courseId).orElseThrow();
        Enrollment enrollment = new Enrollment(null, student, course, 0.0);
        return ResponseEntity.ok(enrollRepo.save(enrollment));
    }

    @GetMapping("/my-enrollments/{studentId}")
    public ResponseEntity<List<Enrollment>> myEnrollments(@PathVariable Long studentId) {
        return ResponseEntity.ok(enrollRepo.findByStudentId(studentId));
    }
}
