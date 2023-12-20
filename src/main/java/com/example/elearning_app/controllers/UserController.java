package com.example.elearning_app.controllers;
import com.example.elearning_app.models.user.User;
import com.example.elearning_app.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> index() {
        return userService.users();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{email}")
    public Optional<User> get(@PathVariable String email) {
        return userService.getUser(email);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("user deleted.");
    }

    @PutMapping("/{id}")
    public User update(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
    @PutMapping("/{id}/{courseId}")
    public User updateEnrolled(@PathVariable int id, @PathVariable int courseId) {
        return userService.updateEnrolled(id, courseId);
    }
}
