package com.example.elearning_app.services;
import com.example.elearning_app.models.lesson.Lesson;
import com.example.elearning_app.models.quiz.Quiz;
import com.example.elearning_app.models.quiz.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public List<Quiz> quizzes() {
        return quizRepository.findAll();
    }

    public Optional<Quiz> getQuiz(int id) {
        return quizRepository.findById(id);
    }

    public void deleteQuiz(int id) { quizRepository.deleteById(id);
    }

    public Quiz updateQuiz(int id, Quiz quiz) {
        var uQuiz = quizRepository.getReferenceById(id);
        uQuiz.setAnswers(quiz.getAnswers());
        uQuiz.setCorrect(quiz.getCorrect());
        uQuiz.setQuestion(quiz.getQuestion());
        return quizRepository.save(uQuiz);
    }
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }
}
