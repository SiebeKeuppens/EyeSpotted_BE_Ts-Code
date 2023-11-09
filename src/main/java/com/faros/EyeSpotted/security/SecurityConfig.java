package com.faros.EyeSpotted.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain contactcenterSecurityFilterChain(HttpSecurity http, EyeSpottedAuthenticationTokenFactory authenticationTokenFactory) throws Exception {
        final String[] matchers = new String[] {"/expeditions/**", "/animals/**", "/expedition-targets/**", "/tags/**", "/users/**"};

        http.csrf(AbstractHttpConfigurer::disable);
        http.cors(Customizer.withDefaults());

        http.securityMatcher(matchers).addFilterBefore(new EyeSpottedAuthenticationFilter(authenticationTokenFactory), AuthorizationFilter.class)
                .authorizeHttpRequests((customizer) -> customizer.requestMatchers(matchers).authenticated());

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        corsConfiguration.setAllowedOrigins(List.of("*"));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS"));
        corsConfiguration.setAllowedHeaders(List.of("authorization", "content-type"));

        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;

    }
}
