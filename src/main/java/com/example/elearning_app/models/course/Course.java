package com.example.elearning_app.models.course;
import com.example.elearning_app.models.lesson.Lesson;
import com.example.elearning_app.models.quiz.Quiz;
import com.example.elearning_app.models.user.User;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Course {
    @Id
    @GeneratedValue
    @Column(name = "course_id")
    private int courseId;
    @Column(nullable = false)
    private String name;
    private String description;
    private String imgSrc;
    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledCourses")
    private Set<User> students = new HashSet<>();
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Lesson> lessons;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<Quiz> quizzes;

    public Course( String name, String description, String imgSrc, Set<Lesson> lessons) {
        this.name = name;
        this.description = description;
        this.imgSrc = imgSrc;
        this.lessons = lessons;
    }

}
