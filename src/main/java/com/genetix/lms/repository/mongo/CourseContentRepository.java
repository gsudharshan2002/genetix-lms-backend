package com.genetix.lms.repository.mongo;

import com.genetix.lms.model.mongo.CourseContent;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface CourseContentRepository extends MongoRepository<CourseContent, String> {
    Optional<CourseContent> findByCourseId(Long courseId);
}
