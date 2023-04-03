package com.usermanager.config;

import com.usermanager.config.filter.JWTAuthenticationFilter;
import com.usermanager.config.filter.JWTAuthorizationFilter;
import com.usermanager.users.UserRepository;
import com.usermanager.users.services.UserDetailsServiceImpl;
import com.usermanager.utils.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final UserDetailsServiceImpl userDetailsService;

    private JWTUtil jwtUtil = new JWTUtil();

    private final UserRepository userRepository;

    private AuthEntryPointJwt unauthorizedHandler = new AuthEntryPointJwt();

    private final AuthenticationConfiguration configuration; // remover?

    private static final String[] PUBLIC_MATCHERS = {
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v3/api-docs/**"
    };

    private static final String[] PUBLIC_MATCHERS_GET = {

    };

    private static final String[] PUBLIC_MATCHERS_POST = {
            "/api/user"
    };

    private static final String[] PUBLIC_MATCHERS_PUT = {

    };

    private static final String[] PUBLIC_MATCHERS_DELETE = {

    };

    private static final String[] PUBLIC_MATCHERS_PATCH = {

    };

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .cors(orsSpec -> corsConfigurationSource())
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
//                .antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
//                .antMatchers(HttpMethod.PUT, PUBLIC_MATCHERS_PUT).permitAll()
//                .antMatchers(HttpMethod.DELETE, PUBLIC_MATCHERS_DELETE).permitAll()
//                .antMatchers(HttpMethod.PATCH, PUBLIC_MATCHERS_PATCH).permitAll()
//                .antMatchers(PUBLIC_MATCHERS).permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil, userRepository))
//                .addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
                .requestMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
                .requestMatchers(HttpMethod.PUT, PUBLIC_MATCHERS_PUT).permitAll()
                .requestMatchers(HttpMethod.DELETE, PUBLIC_MATCHERS_DELETE).permitAll()
                .requestMatchers(HttpMethod.PATCH, PUBLIC_MATCHERS_PATCH).permitAll()
                .requestMatchers(PUBLIC_MATCHERS).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager(configuration), jwtUtil, userRepository))
                .addFilter(new JWTAuthorizationFilter(authenticationManager(configuration), jwtUtil, userDetailsService));


        return http.build();
    }
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setAllowedMethods(Collections.singletonList("*"));
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }


}