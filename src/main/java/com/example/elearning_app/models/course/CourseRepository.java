package com.example.elearning_app.models.course;

import com.example.elearning_app.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findAllByOrderByStudents();
}
