package com.springboot.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public WebSecurityCustomizer configure() {
        return (web -> web.ignoring()
                .requestMatchers(new AntPathRequestMatcher("/**"))
        );
    }
//
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(
//                                new AntPathRequestMatcher("/user/signin"),
//                                new AntPathRequestMatcher("/user/signup"),
//                                new AntPathRequestMatcher("/user/logout"),
//                                new AntPathRequestMatcher("/projects")
//                        ).permitAll()
//                        .anyRequest().authenticated())
//                .formLogin(formlogin -> formlogin
//                        .loginPage("/user/signin")
//                        .defaultSuccessUrl("/home")
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/user/signin")
//                        .invalidateHttpSession(true)
//                        .permitAll()
//                )
//                .rememberMe(rememberMe -> rememberMe
//                        .key("uniqueAndSecret")
//                        .tokenValiditySeconds(86400) // 1 day
//                )
//                .csrf(AbstractHttpConfigurer::disable)
//                .build();
//    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
