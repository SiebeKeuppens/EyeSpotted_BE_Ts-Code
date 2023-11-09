package com.faros.EyeSpotted.security;

import com.faros.EyeSpotted.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class EyeSpottedSecurityContextHolder {
    /**
     * This returns an actual entity, careful with transactions
     *
     * @return Active user
     */
    public static User getUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
