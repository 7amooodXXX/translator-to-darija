package com.example.translator.security;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;


@BasicAuthenticationMechanismDefinition(
    realmName = "translator-realm"
)

@ApplicationScoped
public class SecurityConfig {
}
