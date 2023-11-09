package com.faros.EyeSpotted.controller;

import com.faros.EyeSpotted.exception.error.EyeSpottedError;
import com.faros.EyeSpotted.model.DTO.LoginDetailDTO;
import com.faros.EyeSpotted.model.DTO.RegisterDetailDTO;
import com.faros.EyeSpotted.service.AuthService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody LoginDetailDTO loginDetail) {
        return authService.login(loginDetail);
    }

    @PostMapping("/register")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content =
                @Content(mediaType = MediaType.APPLICATION_JSON_VALUE ,schema = @Schema(implementation = EyeSpottedError.class))
            )
    })
    public void register(@RequestBody @Valid RegisterDetailDTO registerDetail) {
        authService.register(registerDetail);
    }
}
