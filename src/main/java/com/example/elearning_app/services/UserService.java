package com.example.elearning_app.services;
import com.example.elearning_app.models.course.Course;
import com.example.elearning_app.models.course.CourseRepository;
import com.example.elearning_app.models.user.User;
import com.example.elearning_app.models.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final PasswordEncoder passwordEncoder;


    public List<User> users() {
        return userRepository.findAll();
    }

    public User getUser(String email) {
        return userRepository.findUserByEmail(email).get();
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User updateUser(int id, User user) {
        var uUser = userRepository.getReferenceById(id);
        uUser.setName(user.getName());
        uUser.setEmail(user.getEmail());
        if(user.getPassword() != null && !user.getPassword().equals(""))
            uUser.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(uUser);
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateEnrolled(int id, int courseId) {
        var uUser = userRepository.findById(id).get();
        var uCourse = courseRepository.findById(courseId).get();
        uUser.getEnrolledCourses().add(uCourse);
        return userRepository.save(uUser);
    }
}
