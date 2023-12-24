package com.example.elearning_app.controllers;
import com.example.elearning_app.models.course.Course;
import com.example.elearning_app.models.course.CourseRepository;
import com.example.elearning_app.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> index() {
        return courseService.courses();
    }
    @GetMapping("/trending")
    public List<Course> trendingIndex() {
        return courseService.TrendingCourses();
    }
    @PostMapping
    public Course create(@RequestBody Course course) {
        return courseService.createCourse(course);
    }
    @GetMapping("/{id}")
    public Optional<Course> getCourse(@PathVariable int id) {
        return courseService.getCourse(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok("course deleted.");
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable int id, @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }
    @PostMapping("/{id}/{lessonId}")
    public Course addLesson(@PathVariable int id, @PathVariable int lessonId) {
        return courseService.addLesson(id, lessonId);
    }
    @PostMapping("/{id}/q/{quizId}")
    public Course addQuiz(@PathVariable int id, @PathVariable int quizId) {
        return courseService.addQuiz(id, quizId);
    }

}
