package com.faros.EyeSpotted.security;

import com.faros.EyeSpotted.model.User;
import com.faros.EyeSpotted.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class EyeSpottedAuthenticationTokenFactory {

    private final UserRepository userRepository;

    public EyeSpottedAuthenticationTokenFactory(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public EyeSpottedAuthenticationToken create(HttpServletRequest request) {
        String authHeader = getAuthorizationHeader(request);
        User user = this.userRepository.findUserByName(authHeader).orElseThrow(EntityNotFoundException::new);
        return new EyeSpottedAuthenticationToken(user, request.getParameterMap());
    }

    private String getAuthorizationHeader(HttpServletRequest request){
        return request.getHeader("Authorization");
    }
}
