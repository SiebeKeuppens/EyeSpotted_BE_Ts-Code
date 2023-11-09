package com.faros.EyeSpotted.service;

import com.faros.EyeSpotted.exception.EmailAlreadyInUseException;
import com.faros.EyeSpotted.exception.InvalidEmailFormatException;
import com.faros.EyeSpotted.exception.UserAlreadyExistsException;
import com.faros.EyeSpotted.model.DTO.LoginDetailDTO;
import com.faros.EyeSpotted.model.DTO.RegisterDetailDTO;
import com.faros.EyeSpotted.model.User;
import com.faros.EyeSpotted.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final Pattern emailPattern;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.emailPattern = Pattern.compile("[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+");
    }

    public boolean login(LoginDetailDTO loginDetail) {
       return userRepository.existsUserByName(loginDetail.getUsername());
    }

    public void register(RegisterDetailDTO registerDetail) {
        final String username = registerDetail.getUsername().trim();
        final String email = registerDetail.getEmail().trim();
        boolean usernameExists = userRepository.existsUserByName(username);
        boolean emailExists = userRepository.existsUserByEmail(email);

        if (usernameExists) {
            throw new UserAlreadyExistsException("Username is unavailable");
        } else if (emailExists) {
            throw new EmailAlreadyInUseException("Email already in use");
        } else if (!emailPattern.matcher(email).matches()) {
            throw new InvalidEmailFormatException("Email is invalid");
        }

        User user = new User();
        user.setName(username);
        user.setEmail(email);
        user.setPassword(registerDetail.getPassword().trim());
        user.setRole("");

        userRepository.save(user);
    }
}
