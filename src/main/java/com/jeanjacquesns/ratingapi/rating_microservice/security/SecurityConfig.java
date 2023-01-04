package com.jeanjacquesns.ratingapi.rating_microservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Jean Jacques N. Shimwa
 * @created 04-01-2023 - 1:52 PM
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    public void configureGlobal1(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic()
                .disable()
                .authorizeRequests()
                .regexMatchers("^/ratings\\?bookId.*$").authenticated()
                .antMatchers(HttpMethod.POST, "/ratings").authenticated()
                .antMatchers(HttpMethod.PATCH, "/ratings/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/ratings/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/ratings").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf()
                .disable();

        return http.build();
    }
}
