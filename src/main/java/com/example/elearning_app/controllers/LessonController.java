package com.example.elearning_app.controllers;
import com.example.elearning_app.models.lesson.Lesson;
import com.example.elearning_app.services.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/lesson")
public class LessonController {
    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping
    public List<Lesson> index() {
        return lessonService.lessons();
    }

    @PostMapping
    public Lesson create( @RequestBody Lesson lesson) {
        return lessonService.createLesson(lesson);
    }

    @GetMapping("/{id}")
    public Optional<Lesson> get(@PathVariable int id) {
        return lessonService.getLesson(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        lessonService.deleteLesson(id);
        return ResponseEntity.ok("lesson deleted.");
    }

    @PutMapping("/{id}")
    public Lesson update(@PathVariable int id, @RequestBody Lesson lesson) {
        return lessonService.updateLesson(id, lesson);
    }
}
