package com.example.elearning_app.models.lesson;
import com.example.elearning_app.models.course.Course;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Lesson {
    @Id
    @GeneratedValue
    private int lessonId;
    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;


    public Lesson(String title, String content) {
        this.title = title;
        this.content = content;
    }
    @JsonIgnore
    public Course getCourse() {
        return course;
    }


}
