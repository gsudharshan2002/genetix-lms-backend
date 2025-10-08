package com.genetix.lms.controller;

import com.genetix.lms.model.mongo.CourseContent;
import com.genetix.lms.repository.mongo.CourseContentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class CourseContentController {

    private final CourseContentRepository contentRepo;

    public CourseContentController(CourseContentRepository contentRepo) {
        this.contentRepo = contentRepo;
    }

    // Admin: create or update content for a course
    @PostMapping("/course")
    public ResponseEntity<CourseContent> saveContent(@RequestBody CourseContent content) {
        return ResponseEntity.ok(contentRepo.save(content));
    }

    // Any authenticated user (student/admin) can fetch content
    @GetMapping("/course/{courseId}")
    public ResponseEntity<?> getContent(@PathVariable Long courseId) {
        Optional<CourseContent> oc = contentRepo.findByCourseId(courseId);
        return oc.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
