package com.example.elearning_app.controllers;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class AuthRequest {
    private String email;
    private String password;
}
