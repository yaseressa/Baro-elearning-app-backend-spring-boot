package com.example.elearning_app.services;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class Auth extends OncePerRequestFilter {
    private final JWTAuthService authService;
    private final UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
      final String authHeader = request.getHeader("Authorization");
      final String userEmail;
      final String jwt;

      if (authHeader == null || !authHeader.startsWith("Bearer ")){
          filterChain.doFilter(request, response);
          return;
      }
      jwt = authHeader.substring(7);
      userEmail = authService.extractEmail(jwt);
      if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){
          UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
          if(authService.isTokenValid(jwt, userDetails)){
              UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
              authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
              SecurityContextHolder.getContext().setAuthentication(authenticationToken);
          }
      }
      filterChain.doFilter(request, response);
    }
}
