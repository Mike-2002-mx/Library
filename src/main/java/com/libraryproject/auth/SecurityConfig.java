package com.libraryproject.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        private final AuthenticationProvider authenticationProvider;
        private final JwtAuthenticationFilter jwtAuthenticationFilter;

        public SecurityConfig(
                JwtAuthenticationFilter jwtAuthenticationFilter,
                AuthenticationProvider authenticationProvider
        ) {
                this.authenticationProvider = authenticationProvider;
                this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

                http
                        .csrf((csrf) -> csrf.disable())
                        .authorizeHttpRequests(
                                (auth) -> auth
                                .requestMatchers("/auth/**").permitAll()
                                .requestMatchers("/doc/swagger-ui/index.html", "/v3/api-docs*/**").permitAll()
                                .anyRequest().authenticated())
                                        .formLogin(
                                                form ->
                                                form.defaultSuccessUrl("/doc/swagger-ui/index.html", true).permitAll())
                                .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .authenticationProvider(authenticationProvider)
                                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
                                
                return http.build();
        }

        @Bean
        public WebSecurityCustomizer webSecurityCustomizer(){
                return (web) -> web.ignoring()
                .requestMatchers("/doc/swagger-ui/**","/v3/api-docs*/**"); 
        }
}

