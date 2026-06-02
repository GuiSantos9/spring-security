package com.security.br.securities;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;

@Controller // expõe endpoints http
@EnableWebSecurity // ele habilita ou desabilita o web security
public class SecurityConfiguration {

    // registra qualquer objeto no container
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        return httpSecurity.csrf(csrf -> csrf.disable())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers(HttpMethod.GET, "/pessoas").permitAll()
                                .requestMatchers(HttpMethod.POST, "/pessoas").permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/pessoas/**").permitAll()
                                .requestMatchers(HttpMethod.PUT, "/pessoas/**").permitAll())
                .build();
    }

}
