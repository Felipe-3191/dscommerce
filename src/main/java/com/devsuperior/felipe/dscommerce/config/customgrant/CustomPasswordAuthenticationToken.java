package com.devsuperior.felipe.dscommerce.config.customgrant;

import jakarta.annotation.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AuthorizationGrantAuthenticationToken;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomPasswordAuthenticationToken extends OAuth2AuthorizationGrantAuthenticationToken {

    private final String username;
    private final String password;
    private final Set<String> scopes;

    protected CustomPasswordAuthenticationToken(Authentication clientPrincipal, @Nullable Map<String, Object> additionalParameters, @Nullable Set<String> scopes) {
        super(new AuthorizationGrantType("password"), clientPrincipal, additionalParameters);

        this.username = (String) additionalParameters.get("username");
        this.password = (String) additionalParameters.get("password");
        this.scopes = Collections.unmodifiableSet(scopes != null ? new HashSet<>(scopes) : Collections.emptySet());

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<String> getScopes() {
        return scopes;
    }
}
