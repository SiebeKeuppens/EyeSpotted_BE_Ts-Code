package com.faros.EyeSpotted.security;

import com.faros.EyeSpotted.model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Map;

public class EyeSpottedAuthenticationToken extends UsernamePasswordAuthenticationToken {

    @Serial
    private static final long serialVersionUID = 5948439L;
    private transient final User user;

    public EyeSpottedAuthenticationToken(User user, Map<String, String[]> params) {
        super(user, params, new ArrayList<>());
        this.user = user;
    }
    public User getUser() {
        return user;
    }

    @Override
    public Object getPrincipal() {
        return user;
    }
}
