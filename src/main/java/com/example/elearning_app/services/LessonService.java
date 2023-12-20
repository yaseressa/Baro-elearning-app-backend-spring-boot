package com.example.elearning_app.services;

import com.example.elearning_app.models.lesson.Lesson;
import com.example.elearning_app.models.lesson.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> lessons() {
        return lessonRepository.findAll();
    }

    public Optional<Lesson> getLesson(int id) {
        return lessonRepository.findById(id);
    }

    public void deleteLesson(int id) {
        lessonRepository.deleteById(id);
    }

    public Lesson updateLesson(int id, Lesson lesson) {
        var uLesson = lessonRepository.getReferenceById(id);
        uLesson.setTitle(lesson.getTitle());
        uLesson.setContent(lesson.getContent());
        return lessonRepository.save(uLesson);
    }
    public Lesson createLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }
}
