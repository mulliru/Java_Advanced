package br.com.fiap.spring_mvc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                authorizeRequests ->
                    authorizeRequests
                            .requestMatchers("/").permitAll()
                            .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 ->
                        oauth2.defaultSuccessUrl("/livro/lista"))
                .formLogin(Customizer.withDefaults())
                .build();
    }
}
