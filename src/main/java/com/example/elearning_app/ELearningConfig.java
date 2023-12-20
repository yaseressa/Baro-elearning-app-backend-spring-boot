package com.example.elearning_app;

import com.example.elearning_app.models.course.Course;
import com.example.elearning_app.models.course.CourseRepository;
import com.example.elearning_app.models.lesson.Lesson;
import com.example.elearning_app.models.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.List;

@Configuration
public class ELearningConfig {

    CourseRepository courseRepository;
    private final UserRepository repository;

    public ELearningConfig(CourseRepository courseRepository, UserRepository repository) {
        this.courseRepository = courseRepository;
        this.repository = repository;
    }


    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {


            var courses = List.of(
                    new Course
                            (
                                    "HTML",
                                    "html.png",
                                    "No prior coding experience? No problem! This beginner-friendly course will guide you through the fundamentals of HTML, the language that builds the websites you use every day.",
                                    new HashSet<>(
                                            List.of(
                                                    new Lesson("HTML Attributes", "HTML Attributes Are OG"), new Lesson("HTML Attributes", "HTML Attributes Are OG")
                                            ))
                            ),

                    new Course
                            (
                                    "CSS",
                                    "css.png",
                                    "This course is designed to provide a comprehensive introduction to Cascading Style Sheets (CSS) for web development. Participants will learn the fundamentals of styling HTML documents to create visually appealing and responsive web pages.", new HashSet<>(
                                    List.of(
                                            new Lesson("HTML Attributes", "HTML Attributes Are OG"), new Lesson("HTML Attributes", "HTML Attributes Are OG")
                                    ))
                            ),

                    new Course(
                            "C# Programming",
                            "cs.png",
                            "Ever built a castle out of Legos? C# is like the building blocks of software, and this course will be your blueprint for constructing incredible digital creations.", new HashSet<>(
                            List.of(
                                    new Lesson("HTML Attributes", "HTML Attributes Are OG"), new Lesson("HTML Attributes", "HTML Attributes Are OG")
                            ))
                    ),
                    new Course
                            (
                                    "Java Programming",
                                    "java.png",
                                    "Through this course we'll navigate the hidden temples of data structures and algorithms, unleashing the beast of object-oriented programming within you.",
                                    new HashSet<>(
                                            List.of(
                                                    new Lesson("HTML Attributes", "HTML Attributes Are OG"), new Lesson("HTML Attributes", "HTML Attributes Are OG")
                                            ))
                            ),
                    new Course
                            (
                                    "Go Programming",
                                    "go.png",
                                    "Elevate your programming skills with this comprehensive Golang course designed for both beginners and experienced developers seeking to enhance their proficiency. Delve into the elegant design.",
                                    new HashSet<>(
                                            List.of(
                                                    new Lesson("HTML Attributes", "HTML Attributes Are OG"), new Lesson("HTML Attributes", "HTML Attributes Are OG")
                                            ))
                            ));
            courseRepository.saveAll(courses);
        };
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return email -> repository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
