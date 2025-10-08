package com.genetix.lms.model;

import jakarta.persistence.*;

@Entity
@Table(name = "enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User student;

    @ManyToOne
    private Course course;

    private double progress;

    // Constructors
    
    public Enrollment(Long id, User student, Course course, double progress) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.progress = progress;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getStudent() { return student; }
    public void setStudent(User student) { this.student = student; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public double getProgress() { return progress; }
    public void setProgress(double progress) { this.progress = progress; }
}
