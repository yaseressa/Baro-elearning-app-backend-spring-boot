package com.example.elearning_app.controllers;

import lombok.*;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class RegisterReq {
    private String name;
    private String email;
    private String password;
}
