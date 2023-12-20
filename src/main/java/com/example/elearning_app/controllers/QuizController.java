package com.example.elearning_app.controllers;
import com.example.elearning_app.models.lesson.Lesson;
import com.example.elearning_app.models.quiz.Quiz;
import com.example.elearning_app.services.LessonService;
import com.example.elearning_app.services.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public List<Quiz> index() {
        return quizService.quizzes();
    }

    @PostMapping
    public Quiz create(@RequestBody Quiz quiz) {
        return quizService.createQuiz(quiz);
    }

    @GetMapping("/{id}")
    public Optional<Quiz> get(@PathVariable int id) {
        return quizService.getQuiz(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        quizService.deleteQuiz(id);
        return ResponseEntity.ok("quiz deleted.");
    }

    @PutMapping("/{id}")
    public Quiz update(@PathVariable int id, @RequestBody Quiz quiz) {
        return quizService.updateQuiz(id, quiz);
    }
}