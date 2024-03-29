package com.sommelier.wine4you.config;

import com.sommelier.wine4you.security.jwt.JwtAuthenticationEntryPoint;
import com.sommelier.wine4you.security.jwt.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    private final JwtAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    public SecurityConfig(JwtAuthenticationEntryPoint authenticationEntryPoint) {
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().configurationSource(
                request -> new CorsConfiguration().applyPermitDefaultValues());
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests(
                        (authorize) -> authorize
                                .antMatchers("/api/v1/auth/**").permitAll()
                                .antMatchers(HttpMethod.GET, "/api/v1/carts/**").authenticated()
                                .antMatchers(HttpMethod.GET, "/api/v1/orders/**").authenticated()
                                .antMatchers(HttpMethod.GET, "/api/v1/wines/**").permitAll()
                                .antMatchers(HttpMethod.GET, "/api/v1/promotions").permitAll()
                                .antMatchers(HttpMethod.GET, "/api/v1/events").permitAll()
                                .antMatchers(HttpMethod.GET, "/api/v1/meals").permitAll()
                                .antMatchers(HttpMethod.GET, "/api/v1/styles").permitAll()
                                .antMatchers(HttpMethod.GET, "/api/v1/tastes").permitAll()
                                .antMatchers(HttpMethod.POST, "/api/v1/**images/**").permitAll()
                                .antMatchers("/v2/api-docs/**").permitAll()
                                .antMatchers("/swagger-ui/**").permitAll()
                                .antMatchers("/swagger-resources/**").permitAll()
                                .antMatchers("/swagger-ui.html").permitAll()
                                .antMatchers("/webjars/**").permitAll()
                                .anyRequest()
                                .authenticated());
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
