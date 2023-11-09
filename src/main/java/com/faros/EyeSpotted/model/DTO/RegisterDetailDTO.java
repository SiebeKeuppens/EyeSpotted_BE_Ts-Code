package com.faros.EyeSpotted.model.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDetailDTO {
    @NotNull
    @Size(min = 1)
    private String username;
    @NotNull
    @Size(min = 3)
    private String email;
    @NotNull
    @Size(min = 1)
    private String password;
    @NotNull
    @Size(min = 1)
    private String repeatPassword;
}
