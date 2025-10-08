package com.genetix.lms.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "lms_content")
public class CourseContent {

    @Id
    private String id;
    private Long courseId;
    private List<Module> modules;

    public CourseContent() {}
    public CourseContent(String id, Long courseId, List<Module> modules) {
        this.id = id;
        this.courseId = courseId;
        this.modules = modules;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }

    public List<Module> getModules() { return modules; }
    public void setModules(List<Module> modules) { this.modules = modules; }

    public static class Module {
        private String title;
        private List<String> videos;
        private List<String> resources;

        public Module() {}
        public Module(String title, List<String> videos, List<String> resources) {
            this.title = title;
            this.videos = videos;
            this.resources = resources;
        }

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public List<String> getVideos() { return videos; }
        public void setVideos(List<String> videos) { this.videos = videos; }

        public List<String> getResources() { return resources; }
        public void setResources(List<String> resources) { this.resources = resources; }
    }
}
