package com.example.elearning_app.services;
import com.example.elearning_app.models.course.Course;
import com.example.elearning_app.models.course.CourseRepository;
import com.example.elearning_app.models.lesson.LessonRepository;
import com.example.elearning_app.models.quiz.QuizRepository;
import com.example.elearning_app.models.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final LessonRepository lessonRepository;
    private final QuizRepository quizRepository;


    public List<Course> courses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourse(int id) {
        return courseRepository.findById(id);
    }

    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }

    public Course updateCourse(int id, Course course) {
        var uCourse = courseRepository.getReferenceById(id);
        uCourse.setName(course.getName());
        uCourse.setDescription(course.getDescription());
        uCourse.setLessons(course.getLessons());
        uCourse.setQuizzes(course.getQuizzes());
        return courseRepository.save(uCourse);
    }
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course addLesson(int id, int lessonId) {
        var lesson = lessonRepository.findById(lessonId).get();
        var course = courseRepository.findById(id).get();
        lesson.setCourse(course);
        lessonRepository.save(lesson);
        course.getLessons().add(lesson);
        return courseRepository.save(course);
    }
    public List<Course> TrendingCourses() {
        return courseRepository.findAllByOrderByStudents().subList(0, 4);
    }

    public Course addQuiz(int id, int quizId) {
        var quiz = quizRepository.findById(quizId).get();
        var course = courseRepository.findById(id).get();
        quiz.setCourse(course);
        quizRepository.save(quiz);
        course.getQuizzes().add(quiz);
        return courseRepository.save(course);
    }
}
