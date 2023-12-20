package com.example.elearning_app.services;

import com.example.elearning_app.controllers.AuthRequest;
import com.example.elearning_app.controllers.AuthResponse;
import com.example.elearning_app.controllers.RegisterReq;
import com.example.elearning_app.models.user.User;
import com.example.elearning_app.models.user.UserRepository;
import lombok.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Data
@RequiredArgsConstructor
@Builder
@Component
public class AuthService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JWTAuthService jwtAuthService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterReq request) {
        var user = new User(request.getName(), request.getEmail(), passwordEncoder.encode(request.getPassword()));
        repository.save(user);
        var jwt = jwtAuthService.generateToken(user);
        return AuthResponse.builder().token(jwt).build();
    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findUserByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtAuthService.generateToken(user);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
