package com.example.elearning_app.models.quiz;
import com.example.elearning_app.models.course.Course;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Quiz {
    @Id
    @GeneratedValue
    private int quizId;
    @Column(nullable = false)
    private String question;
    @Column(nullable = false)
    private String answers;
    private int correct;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;


    public Quiz(String question, String answers, int correct) {
        this.question = question;
        this.answers = answers;
        this.correct = correct;
    }
    @JsonIgnore
    public Course getCourse() {
        return course;
    }

}
