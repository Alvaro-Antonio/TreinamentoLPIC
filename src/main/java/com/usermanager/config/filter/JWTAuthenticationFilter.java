package com.usermanager.config.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usermanager.security.dto.CredentialsDTO;
import com.usermanager.users.User;
import com.usermanager.users.dto.UserSuccessfulLoginDTO;
import com.usermanager.users.UserRepository;
import com.usermanager.utils.JWTUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    private JWTUtil jwtUtil;

    private UserRepository userRepository;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil, UserRepository userRepository) {
        setAuthenticationFailureHandler(new JWTAuthenticationFailureHandler());
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {

        try {
            CredentialsDTO credentials = new ObjectMapper().readValue(req.getInputStream(), CredentialsDTO.class);
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(credentials.getEmail(),
                    credentials.getPassword(), new ArrayList<>());
            return authenticationManager.authenticate(authToken);
        } catch (IOException e) {
            throw new AuthenticationCredentialsNotFoundException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
                                         Authentication auth) throws IOException {
        User loggedUser = (User) auth.getPrincipal();
        loggedUser.setLastLoginDate(LocalDateTime.now());
        this.userRepository.save(loggedUser);

        String token = jwtUtil.generateToken(loggedUser.getUsername(), loggedUser.getId().toString());
        res.addHeader("Authorization", "Bearer " + token);
        res.setCharacterEncoding("UTF8");

        UserSuccessfulLoginDTO responseUser = UserSuccessfulLoginDTO.from(loggedUser);
        responseUser.setToken(token);
        ObjectMapper om = new ObjectMapper();
        String jsonString = om.writeValueAsString(responseUser);
        res.getWriter().write(jsonString);

        res.getWriter().flush();
        res.getWriter().close();
        res.addHeader("access-control-expose-headers", "Authorization");
    }

    private static class JWTAuthenticationFailureHandler implements AuthenticationFailureHandler {

        @Override
        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                            AuthenticationException exception) throws IOException, ServletException {
            response.setStatus(401);
            response.setContentType("application/json");
            response.getWriter().append(json());
        }

        private String json() {
            long date = new Date().getTime();
            return "{\"timestamp\": " + date + ", " +
                    "\"status\": 401, " +
                    "\"error\": \"Access denied\", " +
                    "\"message\": \"Invalid Email or password\", " +
                    "\"path\": \"/login\"}";
        }
    }

}