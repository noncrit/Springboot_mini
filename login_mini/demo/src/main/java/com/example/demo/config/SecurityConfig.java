package com.example.demo.config;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/home", "/login","registerPage","/register").permitAll() // Allow access to these paths without authentication
                        // /admin/**로 시작하는 모든 URL은 ADMIN 역할을 가진 사용자만 접근 가능
                        .requestMatchers("/admin/**").hasRole("admin") //prefix ROLE_ 이 앞쪽으로 붙는형태
                        .requestMatchers("/user-list").hasAuthority("admin") // user-list는 시작하는 모든 URL은 ADMIN 역할을 가진 사용자만 접근 가능

                        .requestMatchers("/user/**").hasRole("user") // /user/**로 시작하는 모든 URL은 USER 역할을 가진 사용자만 접근 가능
                        .anyRequest().authenticated() // All other requests need authentication
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .permitAll()
                )
                .logout(logout -> logout
                        .permitAll()
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/home")
                )
                .exceptionHandling(exceptions -> exceptions
                        .accessDeniedPage("/error/403") // Access denied page
                );
        return http.build();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    //passwordEncoder를 static 으로 선언해야 순환 참조 방지 가능
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
}
