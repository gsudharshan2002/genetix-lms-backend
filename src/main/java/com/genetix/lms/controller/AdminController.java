package com.genetix.lms.controller;

import com.genetix.lms.model.Course;
import com.genetix.lms.repository.CourseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final CourseRepository courseRepo;

    public AdminController(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    @PostMapping("/course")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseRepo.save(course));
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses() {
        return ResponseEntity.ok(courseRepo.findAll());
    }

    @DeleteMapping("/course/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
        courseRepo.deleteById(id);
        return ResponseEntity.ok(Map.of("message", "Course deleted"));
    }
}
